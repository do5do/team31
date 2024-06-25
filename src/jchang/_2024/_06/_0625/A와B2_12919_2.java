package jchang._2024._06._0625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B2_12919_2 {
  // AB로만 이루어진 영어 단어
  // 두 문자열 S와 T가 주어지면, S를 T로 바꾸는 게임
  // - 문자열 뒤에 A 추가
  // - 문자열 뒤에 B를 추가하고 문자열 뒤집기
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    String t = br.readLine();

    if (dfs(s, t)) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }

  private static boolean dfs(String s, String t) {
    if (s.length() == t.length()) {
      return s.equals(t);
    }

    if (t.endsWith("A")) {
      if (dfs(s, t.substring(0, t.length() - 1))) {
        return true;
      }
    }

    if (t.startsWith("B")) {
      StringBuilder sb = new StringBuilder();
      sb.append(t.substring(1)).reverse();
      return dfs(s, sb.toString());
    }

    return false;
  }
}
