package tjoon._0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 좋은수열_2661 {

  static int n;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    dfs(0, "");

  }

  private static void dfs(int idx, String s) {
    if (idx == n) {
      System.out.println(s);
      System.exit(0);
    }

    for (int i = 1; i < 4; i++) {
      if (check(s + i)) {
        dfs(idx + 1, s + i);
      }
    }

  }

  private static boolean check(String s) {
    int len = s.length() / 2;
    int size = s.length();

    for (int i = 1; i <= len; i++) {
      String front = s.substring(size - i * 2, size - i);
      String end = s.substring(size - i);

      if (front.equals(end)) {
        return false;
      }
    }

    return true;
  }

}
