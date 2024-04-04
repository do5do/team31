package jchang._0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주식_11501 {
  // 반례
  // 1
  // 4
  // 1 4 1 10 8 9
  // 12321

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());

      int[] prices = new int[n];
      for (int j = 0; j < n; j++) {
        prices[j] = Integer.parseInt(st.nextToken());
      }

      long sum = 0;
      int max = prices[n - 1];
      for (int j = n - 2; j >= 0 ; j--) {
        if (prices[j] > max) {
          max = prices[j];
        } else {
          sum += max - prices[j];
        }
      }

      sb.append(sum).append("\n");
    }

    System.out.println(sb);
  }
}
