package jchang._2024._05._0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class $1의개수세기_9527 {
  static long[] dp = new long[55];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());

    setUpDp();
    long result = cal(b) - cal(a - 1);
    System.out.println(result);
  }

  private static void setUpDp() {
    dp[0] = 1;
    for (int i = 1; i < dp.length; i++) {
      dp[i] = (dp[i - 1] << 1) + (1L << i);
    }
  }

  private static long cal(long n) {
    long count = n & 1;
    int size = (int) (Math.log(n) / Math.log(2));
    for (int i = size; i > 0; i--) {
      if ((n & (1L << i)) != 0L) {
        count += dp[i - 1] + (n - (1L << i) + 1);
        n -= (1L << i);
      }
    }
    return count;
  }
}
// 참고 : https://tussle.tistory.com/1022