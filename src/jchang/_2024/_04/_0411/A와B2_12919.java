package jchang._2024._04._0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B2_12919 {
  public static void main(String[] args) throws IOException {
    // 15%.. 시간초과
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    String t = br.readLine();

    int result = 0;
    if (dfs(s, t)) {
      result = 1;
    }
    System.out.println(result);
  }

  private static boolean dfs(String s, String t) {
    if (t.length() <= s.length()) {
      return t.equals(s);
    }

    boolean isPass = false;

    // 연산 1
    if (t.endsWith("A")) {
      isPass = dfs(s, t.substring(0, t.length() - 1));
      if (isPass) {
        return true;
      }
    }

    // 연산 2
    if (t.startsWith("B")) {
      StringBuilder operation2 = new StringBuilder(t.substring(1));
      return dfs(s, operation2.reverse().toString());
    }

    return false;
  }
}
