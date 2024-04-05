package jchang._2024._03._0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 암호만들기_1759 {
  static int L;
  static int C;
  static char[] chars;
  static char[] result;
  static List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    chars = br.readLine().replace(" ", "").toCharArray();
    Arrays.sort(chars);

    result = new char[L];

    dfs(0, 0);


  }

  private static void dfs(int start, int idx) {

    if (idx == L) {
      int vowelCount = 0;
      int consonantCount = 0;
      for (char ch : result) {
        if (vowels.contains(ch)) {
          vowelCount++;
        } else {
          consonantCount++;
        }
      }

      if (vowelCount >= 1 && consonantCount >= 2) {
        System.out.println(result);
      }
      return;
    }

    for (int i = start; i < chars.length ; i++) {
      result[idx] = chars[i];
      dfs(i + 1, idx + 1);
    }

  }
}
