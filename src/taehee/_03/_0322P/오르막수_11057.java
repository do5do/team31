package taehee._03._0322P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class 오르막수_11057 {

  static int[] dp = new int[1001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    dp[1] = 10;
    dp[2] = 55;

//    for (int i = 3; i <= N; i++) {
//      dp[i] = dp[i - 1] + 1;
//
//      int sum = 0;
//      int count = 0;
//      for (int i )
//    }

    // fun (9)
    // fun (9) + 8, 7, 6, 5, 4, 3, 2, 1

    int sum =0;
    for (int i = 1; i <=9; i++) {
      sum += sum(i);
    }

    System.out.println(sum + 55);
//    System.out.println(dp[N]);
  }

  static int sum(int num) {
    return IntStream.range(1, num + 1).sum();
  }
}
