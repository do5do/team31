package jchang._2024._03._0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단어공부_1157 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    str = str.toUpperCase();

    int[] alphabet = new int[26];
    int max = 0;
    int maxIdx = -1;
    for (int i = 0; i < str.length(); i++) {
      int idx = str.charAt(i) - 'A';
      alphabet[idx]++;
      if (alphabet[idx] > max) {
        max = alphabet[idx];
        maxIdx = idx;
      }
    }

    int[] ordered = alphabet.clone();
    Arrays.sort(ordered);
    if (str.length() != 1 && ordered[25] == ordered[24]) {
      System.out.println("?");
      System.exit(0);
    }

    System.out.println((char) (maxIdx + 'A'));

  }
}
