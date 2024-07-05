package jchang._2024._07._0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지_4485_2 {
  // 링크는 0, 0에 있다.
  // 도착지 n - 1, n - 1
  // 잃는 금액을 최소로 하여 동굴 건너편까지 이동해야 함
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{1, -1, 0, 0};

    StringBuilder sb = new StringBuilder();

    int n;
    int stage = 0;
    while ((n = Integer.parseInt(br.readLine())) != 0) {
      stage++;
      int[][] board = new int[n][n];
      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          board[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int[][] dp = new int[n][n];
      for (int i = 0; i < n; i++) {
        Arrays.fill(dp[i], Integer.MAX_VALUE);
      }

      dp[0][0] = board[0][0];

      PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[2] - y[2]);

      pq.add(new int[]{0, 0, dp[0][0]});

      while (!pq.isEmpty()) {
        int[] cur = pq.poll();

        for (int i = 0; i < dx.length; i++) {
          int nx = cur[0] + dx[i];
          int ny = cur[1] + dy[i];

          if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
            continue;
          }

          if (dp[nx][ny] > dp[cur[0]][cur[1]] + board[nx][ny]) {
            dp[nx][ny] = dp[cur[0]][cur[1]] + board[nx][ny];
            pq.add(new int[]{nx, ny, dp[nx][ny]});
          }
        }
      }

      sb.append("Problem ").append(stage).append(": ").append(dp[n - 1][n - 1]).append("\n");
    }
    System.out.println(sb);
  }
}
