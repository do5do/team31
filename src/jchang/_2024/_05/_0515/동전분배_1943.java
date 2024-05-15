package jchang._2024._05._0515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전분배_1943 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 3; i++) {
      sb.append(solve(br)).append("\n");
    }

    System.out.println(sb);
  }

  private static int solve(BufferedReader br) throws IOException {
    int n = Integer.parseInt(br.readLine());


    int total = 0;
    Coin[] coins = new Coin[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int price = Integer.parseInt(st.nextToken());
      int amount = Integer.parseInt(st.nextToken());
      total += price * amount;
      coins[i] = new Coin(price, amount);
    }

    if (total % 2 != 0) {
      return 0;
    }


    int target = total / 2;

    int[][] dp = new int[n + 1][target + 1];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    dp[0][0] = 0;

    for (int i = 0; i < coins.length; i++) {
      Coin coin = coins[i];
      for (int j = 0; j <= target; j++) {
        if (dp[i][j] == Integer.MAX_VALUE) {
          continue;
        }
        if (j + coin.price <= target && dp[i][j] < coin.amount) {
          dp[i][j + coin.price] = Math.min(dp[i][j + coin.price], dp[i][j] + 1);
        }
        dp[i + 1][j] = 0;
      }
    }

    if (dp[n][target] == 0) {
      return 1;
    } else {
      return 0;
    }

  }

  static class Coin {
    int price, amount;
    public Coin(int price, int amount) {
      this.price = price;
      this.amount = amount;
    }
  }
}
// https://blog.naver.com/adamdoha/222086394461 참고함
