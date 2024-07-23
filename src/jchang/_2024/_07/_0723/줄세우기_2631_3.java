package jchang._2024._07._0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 줄세우기_2631_3 {
  // 줄 세우는데 최소로 이동하는 아이들의 수를 구하라
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] input = new int[n];
    for (int i = 0; i < n; i++) {
      input[i] = Integer.parseInt(br.readLine());
    }

    int[] dp = new int[n];
    dp[0] = 1;
    int maxLis = 0;
    for (int i = 1; i < n; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (input[j] < input[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      maxLis = Math.max(maxLis, dp[i]);
    }

    System.out.println(n - maxLis);
  }
}
