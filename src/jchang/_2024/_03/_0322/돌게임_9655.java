package jchang._2024._03._0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌게임_9655 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    boolean[] dp = new boolean[1001];
    dp[1] = true;
    dp[2] = false;
    dp[3] = true;

    for (int i = 4; i <= N ; i++) {
      if (dp[i - 1] && dp [i - 3]) {
        dp[i] = false;
      } else {
        dp[i] = true;
      }
    }

    if (dp[N]) {
      System.out.println("SK");
    } else {
      System.out.println("CY");
    }
  }
}
