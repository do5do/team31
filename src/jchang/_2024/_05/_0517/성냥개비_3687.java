package jchang._2024._05._0517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 성냥개비_3687 {
  static long[] minDp = new long[101];  // index : 성냥 개수 , value : 성냥으로 만들수 있는 숫자

  static String[] addForMin = {"1", "7", "4", "2", "0", "8"};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    Arrays.fill(minDp, Long.MAX_VALUE);
    minDp[2] = 1;
    minDp[3] = 7;
    minDp[4] = 4;
    minDp[5] = 2;
    minDp[6] = 6;
    minDp[7] = 8;
    minDp[8] = 10;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      sb.append(makeMin(n)).append(" ").append(makeMax(n)).append("\n");
    }
    System.out.println(sb);
  }

  private static long makeMin(int n) {
    for (int i = 9; i <= n; i++) {
      for (int j = 2; j <= 7; j++) {
        String line = minDp[i - j] + addForMin[j - 2];
        minDp[i] = Math.min(Long.parseLong(line), minDp[i]);
      }
    }
    return minDp[n];
  }

  private static String makeMax(int n) {
    StringBuilder result = new StringBuilder();
    if (n % 2 == 1 && n > 1) {
      result.append("7");
      n -= 3;
      while (n > 0) {
        result.append("1");
        n -= 2;
      }
    } else {
      while (n > 0) {
        result.append("1");
        n -= 2;
      }
    }
    return result.toString();
  }
}
