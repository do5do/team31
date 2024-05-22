package jchang._2024._05._0520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇조종하기_2169 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] board = new int[n][m];
    int[][] dp = new int[n][m];
    int[][] temp = new int[2][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dp[0][0] = board[0][0];

    for (int i = 1; i < m; i++) {
      dp[0][i] = dp[0][i - 1] + board[0][i];
    }

    for (int i = 1; i < n; i++) {
      temp[0][0] = dp[i - 1][0] + board[i][0];
      for (int j = 1; j < m; j++) {
        temp[0][j] = Math.max(dp[i - 1][j], temp[0][j - 1]) + board[i][j];
      }

      temp[1][m - 1] = dp[i - 1][m - 1] + board[i][m - 1];
      for (int j = m - 2; j >= 0; j--) {
        temp[1][j] = Math.max(dp[i - 1][j], temp[1][j + 1]) + board[i][j];
      }

      for (int j = 0; j < m; j++) {
        dp[i][j] = Math.max(temp[0][j], temp[1][j]);
      }
    }

    System.out.println(dp[n - 1][m - 1]);
  }

}
