package jchang._2024._05._0527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌게임_9655_2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] dp = new String[1001];
    dp[1] = "SK";
    dp[2] = "CY";
    dp[3] = "SK";
    for (int i = 4; i <= n; i++) {
      dp[i] = dp[i - 2];
    }


    System.out.println(dp[n]);
  }
}
