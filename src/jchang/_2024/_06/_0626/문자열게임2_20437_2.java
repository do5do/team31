package jchang._2024._06._0626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열게임2_20437_2 {
  // 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이를 구한다
  // 어떤 문자를 정확히 k개를 포함하고, 문자열의 첫번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열의 길이
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      solve(br);
    }

    System.out.println(sb);
  }

  private static void solve(BufferedReader br) throws IOException {
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    int min = Integer.MAX_VALUE;
    int max = 0;
    int[] alphabet = new int[26];
    for (int i = 0; i < str.length(); i++) {
      alphabet[str.charAt(i) - 'a']++;
      if (alphabet[str.charAt(i) - 'a'] >= k) {
        int count = 0;
        for (int j = i; j >= 0; j--) {
          if (str.charAt(j) == str.charAt(i)) {
            count++;
          }

          if (count == k) {
            min = Math.min(i - j + 1, min);
            max = Math.max(i - j + 1, max);
            break;
          }
        }
      }
    }


    if (min == Integer.MAX_VALUE && max == 0) {
      sb.append(-1);
    } else {
      sb.append(min).append(" ").append(max);
    }
    sb.append("\n");

  }
}
