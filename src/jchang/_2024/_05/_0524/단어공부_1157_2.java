package jchang._2024._05._0524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어공부_1157_2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    str = str.toUpperCase();

    int[] count = new int[26];
    int max = 0;
    for (int i = 0; i < str.length(); i++) {
      count[str.charAt(i) - 'A']++;
      max = Math.max(max, count[str.charAt(i) - 'A']);
    }

    int maxCount = 0;
    int result = 0;
    for (int i = 0; i < count.length; i++) {
      if (count[i] == max) {
        result = i;
        maxCount++;
      }
    }

    if (maxCount > 1) {
      System.out.println("?");
    } else {
      System.out.println((char) (result + 'A'));
    }
  }
}
