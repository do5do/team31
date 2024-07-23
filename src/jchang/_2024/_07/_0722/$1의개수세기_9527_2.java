package jchang._2024._07._0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class $1의개수세기_9527_2 {
  // a <= x <= b 를 만족하는 모든 x의 이진수로 표현했을 때 1의 개수의 합
  static long[] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());

    int max = (int) Math.ceil(Math.log(Math.pow(10, 16))/Math.log(2));
    dp = new long[max + 1];
    dp[0] = 1;
    for (int i = 1; i < dp.length; i++) {
      dp[i] = (dp[i - 1] << 1L) + (1L << i);
    }

    long result = calculate(b) - calculate(a - 1);

    System.out.println(result);
  }

  private static long calculate(long num) {
    long count = num & 1;
    int size = (int) (Math.log(num)/Math.log(2));

    for (int i = size; i >= 1; i--) {
      if ((num & (1L << i)) != 0L) {
        count += dp[i - 1] + (num - (1L << i)) + 1;
        num -= 1L << i;
      }
    }
    return count;
  }
}
