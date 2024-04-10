package jchang._2024._04._0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class $123더하기4_15989 {
  // 1
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      calculate(br);
    }

    System.out.println(sb);
  }

  private static void calculate(BufferedReader br) throws IOException {
    int n = Integer.parseInt(br.readLine());
    int[][] dp = new int[10001][4];

    dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

    for (int i = 4; i <= n; i++) {
      dp[i][1] = dp[i - 1][1];
      dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
      dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i -3][3];
    }

    int sum = 0;
    for (int i = 1; i <= 3 ; i++) {
      sum += dp[n][i];
    }

    sb.append(sum).append("\n");
  }
}
