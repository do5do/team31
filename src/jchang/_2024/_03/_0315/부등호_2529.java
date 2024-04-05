package jchang._2024._03._0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부등호_2529 {
  static boolean[] visited;
  static int k;
  static String[] problem;
  static char[] result;
  static String min = "9999999999";
  static String max = "0";
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    k = Integer.parseInt(br.readLine());

    problem = new String[k];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) {
      problem[i] = st.nextToken();
    }

    visited = new boolean[10];
    result = new char[k + 1];
    dfs(0);

    System.out.println(max);
    System.out.println(min);
  }

  private static void dfs(int idx) {
    if (idx == result.length) {
      long cur = Long.parseLong(new String(result));
      max = Long.parseLong(max) > cur ? max : new String(result);
      min = Long.parseLong(min) < cur ? min : new String(result);
      return;
    }

    for (int i = 0; i < 10; i++) {
      if (idx > 0) {
        int before = result[idx - 1] - '0';
        if (problem[idx - 1].equals(">")) {
          if (before <= i) {
            continue;
          }
        } else {
          if (before >= i) {
            continue;
          }
        }
      }

      if (!visited[i]) {
        result[idx] = (char) (i + '0');
        visited[i] = true;
        dfs(idx + 1);
        visited[i] = false;
      }
    }
  }
}
