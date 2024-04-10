package jchang._2024._04._0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 볼모으기_17615 {

  static char[] array;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    array = br.readLine().toCharArray();


    int left = Math.min(toLeft('R'), toLeft('B'));
    int right = Math.min(toRight('R'), toRight('B'));
    System.out.println(Math.min(left, right));
  }

  private static int toLeft(char start) {
    boolean switching = false;
    int count = 0;
    char target = (start == 'R' ? 'B' : 'R');
    for (int i = 0; i < array.length; i++) {
      if (array[i] == start && switching) {
        count++;
      }
      if (array[i] == target) {
        switching = true;
      }
    }
    return count;
  }

  private static int toRight(char start) {
    boolean switching = false;
    int count = 0;
    char target = (start == 'R' ? 'B' : 'R');
    for (int i = array.length - 1; i >= 0; i--) {
      if (array[i] == start && switching) {
        count++;
      }
      if (array[i] == target) {
        switching = true;
      }
    }
    return count;
  }
}
