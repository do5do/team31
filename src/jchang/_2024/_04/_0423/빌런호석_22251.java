package jchang._2024._04._0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빌런호석_22251 {

  static int n, k, p, x;
  static String[] numbers;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    p = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());

    numbers = new String[10];
    numbers[0] = "1110111";
    numbers[1] = "0000011";
    numbers[2] = "0111110";
    numbers[3] = "0011111";
    numbers[4] = "1001011";
    numbers[5] = "1011101";
    numbers[6] = "1111101";
    numbers[7] = "0010011";
    numbers[8] = "1111111";
    numbers[9] = "1011111";

    int[] targetDisplay = convertToDisplay(x);

    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (i != x) {
        int[] cur = convertToDisplay(i);
        if (canReverse(targetDisplay, cur)) {
          count++;
        }
      }
    }

    System.out.println(count);
  }

  public static boolean canReverse(int[] targetDisplay, int[] cur) {
    int diffCount = 0;
    for (int i = 0; i < targetDisplay.length; i++) {
      for (int j = 0; j < 7; j++) {
        if (numbers[targetDisplay[i]].charAt(j) != numbers[cur[i]].charAt(j)) {
          diffCount++;
        }
        if (diffCount > p) {
          return false;
        }
      }
    }
    return true;
  }

  public static int[] convertToDisplay(int num) {
    int[] display = new int[k];
    for (int i = display.length - 1; i >= 0; i--) {
      display[i] = num % 10;
      num = num / 10;
    }
    return display;
  }
}
