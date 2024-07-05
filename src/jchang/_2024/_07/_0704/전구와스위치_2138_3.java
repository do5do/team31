package jchang._2024._07._0704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 전구와스위치_2138_3 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String origin = br.readLine();
    String want = br.readLine();

    boolean[] from = new boolean[n];
    boolean[] to = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (origin.charAt(i) - '0' == 0) {
        from[i] = true;
      }

      if (want.charAt(i) - '0' == 0) {
        to[i] = true;
      }
    }

    boolean[] fromOnFirst = Arrays.copyOf(from, n);
    fromOnFirst[0] = !from[0];
    fromOnFirst[1] = !from[1];

    int fromCount = 0;
    int fromOnFirstCount = 1;
    for (int i = 0; i < n; i++) {
      if (i != 0) {
        if (from[i - 1] != to[i - 1]) {
          switching(from, i);
          fromCount++;
        }

        if (fromOnFirst[i - 1] != to[i - 1]) {
          switching(fromOnFirst, i);
          fromOnFirstCount++;
        }
      }

      if (Arrays.equals(from, to) && Arrays.equals(fromOnFirst, to)) {
        System.out.println(Math.min(fromCount, fromOnFirstCount));
        return;
      }

      if (Arrays.equals(from, to)) {
        System.out.println(fromCount);
        return;
      }

      if (Arrays.equals(fromOnFirst, to)) {
        System.out.println(fromOnFirstCount);
        return;
      }
    }

    System.out.println(-1);

  }

  private static void switching(boolean[] array, int idx) {
    for (int i = idx - 1; i <= Math.min(array.length - 1, idx + 1); i++) {
      array[i] = !array[i];
    }
  }

}
