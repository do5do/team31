package tjoon._202404._0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _123더하기4_15989 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int n = 0;

    int[][] dp = new int[10001][4];

    dp[1][1] = 1; // 1
    dp[2][1] = 1; // 1 + 1
    dp[2][2] = 1; // 2
    dp[3][1] = 1; // 1 + 1 + 1
    dp[3][2] = 1; // 1 + 2
    dp[3][3] = 1; // 3

    for (int i = 4; i < dp.length; i++) {
      dp[i][1] = dp[i - 1][1];
      // dp[4][1] -> 1 + 1 + 1 + 1 -> dp[3][1] + [1]
      dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
      // dp[4][2] -> 1 + 1 + 2, 2 + 2 -> dp[2][1] + [2], dp[2][2] + [2]
      dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
      // dp[4][3] -> 1 + 3 -> dp[1][1] + [3]
      // dp[1][2] && dp[1][3] == 0
    }

    StringBuilder sb = new StringBuilder();
    for (int t = 0; t < T; t++) {

      n = Integer.parseInt(br.readLine());

      sb.append(dp[n][1] + dp[n][2] + dp[n][3]).append("\n");

    }

    System.out.println(sb);

  }

}
