package jchang._2024._07._0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전분배_1943_2 {
  // 돈을 반으로 나눌 수 있는지 없는지 판단
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 3; i++) {
      solve(br);
    }

    System.out.println(sb);
  }

  private static void solve(BufferedReader br) throws IOException {
    int n = Integer.parseInt(br.readLine());
    int[][] coins = new int[n][2];

    int total = 0;
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int money = Integer.parseInt(st.nextToken());
      int count = Integer.parseInt(st.nextToken());

      coins[i][0] = money;
      coins[i][1] = count;
      total += money * count;
    }

    if (total % 2 == 1) {
      sb.append(0).append("\n");
      return;
    }

    int target = total / 2;

    int[][] dp = new int[n + 1][target + 1];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }

    dp[0][0] = 0;

    for (int i = 0; i < coins.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        if (dp[i][j] == Integer.MAX_VALUE) {
          continue;
        }

        if (j + coins[i][0] < dp[i].length && dp[i][j] < coins[i][1]) {
          dp[i][j + coins[i][0]] = Math.min(dp[i][j] + 1, dp[i][j + coins[i][0]]);
        }

        dp[i + 1][j] = 0;
      }
    }

    if (dp[n][target] == 0) {
      sb.append(1);
    } else {
      sb.append(0);
    }
    sb.append("\n");

  }

}
