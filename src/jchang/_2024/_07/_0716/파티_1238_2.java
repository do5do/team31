package jchang._2024._07._0716;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티_1238_2 {
  // N개의 마을에 한명의 학생이 산다.
  // N개 중 X번 마을에서 파티
  // M개의 단방향 도로, 각각 시간 소비가 있다.
  // 최단시간으로 온다
  // 학생 중 가장 오랜 시간이 걸린 학생
  static int n, m, x;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());

    List<List<int[]>> list = new ArrayList<>();
    List<List<int[]>> reverseList = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      list.add(new ArrayList<>());
      reverseList.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());

      list.get(start).add(new int[]{end, time});
      reverseList.get(end).add(new int[]{start, time});
    }

    int[] from = dijkstra(list);
    int[] to = dijkstra(reverseList);

    int answer = 0;
    for (int i = 0; i < from.length; i++) {
      answer = Math.max(answer, from[i] + to[i]);
    }
    System.out.println(answer);
  }

  private static int[] dijkstra(List<List<int[]>> list) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[x] = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
    pq.add(new int[]{x, 0});

    while (!pq.isEmpty()) {
      int[] cur = pq.poll();

      for (int[] node : list.get(cur[0])) {
        if (dp[cur[0]] + node[1] < dp[node[0]]) {
          dp[node[0]] = dp[cur[0]] + node[1];
          pq.add(new int[]{node[0], dp[node[0]]});
        }
      }
    }

    return dp;
  }
}
