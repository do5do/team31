package jchang._2024._06._0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 지름길_1446_2 {
  // 모든 지름길은 일방통행, 고속도로 역주행 금지
  // 운전해야 하는 거리의 최소값
  // 각 도착지에 도착할 수 있는 최소거리를 구한다.
  // 각 도착지에 도착할 수 있는 최소거리가 될 수 있는 경우의 수는 아래와 같다.
  // 첫째, 왼쪽에서 한칸 이동하는 경우
  // (ex. 3까지 도착하는 최소거리가 3이라면 4의 경우 3까지 도착하는 최소거리 + 1 인 4가 될 수 있다.)
  // 둘째, 도착지를 향해 오는 지름길이 있는 경우
  // (ex. 지금길이 10 30 20으로 주어지고, 10까지 도착할 수 있는 최소거리가 10이라면 30까지 도착할 수 있는 최소거리는
  // 10까지 도착할 수 있는 최소 거리 10 + 지름길 거리 20 인 30이 될 수 있다.)
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    // 지름길을 도착지 기준 오름차순으로 정렬한다.
    PriorityQueue<ShortCut> pq = new PriorityQueue<>(new Comparator<ShortCut>() {
      @Override
      public int compare(ShortCut o1, ShortCut o2) {
        return Integer.compare(o1.end, o2.end);
      }
    });

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int distance = Integer.parseInt(st.nextToken());
      pq.add(new ShortCut(start, end, distance));
    }

    int[] dp = new int[10001];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= d; i++) {
      // 지름길의 도착지점이 현재 구하는 최소거리의 도착지와 같다면
      // 왼쪽에서 한칸 이동해 오는 거리와 지름길을 통해 오는 거리 중 작은 값으로 dp를 갱신해준다.
      if (!pq.isEmpty() && pq.peek().end == i) {
        // 도착지점이 같은 지름길이 여러 개일 수 있기 때문에 while문을 사용하여 전부 비교해준다.
        while (!pq.isEmpty() && pq.peek().end == i) {
          ShortCut shortCut = pq.poll();
          dp[i] = Math.min(Math.min(dp[i - 1] + 1, dp[shortCut.start] + shortCut.distance), dp[i]);
        }
      } else {
        // 현재 구하는 도착지로 오는 지름길이 없으면 왼쪽에서 한칸 이동한다.
        dp[i] = dp[i - 1] + 1;
      }
    }

    System.out.println(dp[d]);
  }

  public static class ShortCut{
    int start, end, distance;

    public ShortCut(int start, int end, int distance) {
      this.start = start;
      this.end = end;
      this.distance = distance;
    }
  }
}
