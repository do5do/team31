package jchang._2024._06._0628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 택배배송_5972_2 {

  // N개의 헛간, 소들의 길 M개의 양방향 길, 각 길은 C_i마리의 소가 있다.
  // 두 개의 헛간은 하나 이상의 길로 연결될 수 있슴
  // 헛간 1에서 출발, N 도착

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 인접리스트를 만들자. 비용이 있기 때문에 Map으로 만들었다.
    // 리스트의 인덱스가 출발지, map의 key가 도착지, map의 value가 비용
    List<Map<Integer, Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new HashMap<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int cow = Integer.parseInt(st.nextToken());

      // 두 개의 헛간은 하나 이상의 길로 연결될 수 있다고 해서 최소 비용을 확인해서 채워줬다.
      graph.get(start).put(end,
          graph.get(start).containsKey(end) ? Math.min(graph.get(start).get(end), cow) : cow);
      graph.get(end).put(start,
          graph.get(end).containsKey(start) ? Math.min(graph.get(end).get(start), cow) : cow);
    }

    // 해당 인덱스(도착지점)까지 올 수 있는 최소비용을 입력하는 배열을 만든다.
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[1] = 0;

    // 비용 순서대로 정렬해야 빨리 찾으므로 PriorityQueue를 사용한다.
    // PriorityQueue의 원소는 int[] 로 배열의 0번째 원소는 도착지점, 배열의 1번째 원소는 도착지점까지의 최소비용이다.
    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
    pq.add(new int[]{1, 0});

    while (!pq.isEmpty()) {
      int[] cur = pq.poll();

      // cur[0]에서 출발하여 도착할 수 있는 장소를 순회하며
      for (Entry<Integer, Integer> entry : graph.get(cur[0]).entrySet()) {
        // 도착할 수 있는 장소의 비용보다 cur[0]에서 출발하여 도착 장소까지 가는 비용이 작은 경우 dp를 업데이트 해준다.
        if (dp[cur[0]] + entry.getValue() < dp[entry.getKey()]) {
          dp[entry.getKey()] = dp[cur[0]] + entry.getValue();
          pq.add(new int[]{entry.getKey(), dp[entry.getKey()]});
        }
      }
    }

    System.out.println(dp[n]);
  }


}
