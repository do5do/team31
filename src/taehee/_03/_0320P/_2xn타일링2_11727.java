package taehee._03._0320P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2xn타일링2_11727 {
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 3;
    dp[3] = 5;
    System.out.println(recursive(n));
  }

  static int recursive(int n) {
    if (dp[n] > 0) {
      return dp[n];
    }

    return dp[n] = (recursive(n - 1) + 2 + recursive(n - 2) ) % 10_007;
  }
}
