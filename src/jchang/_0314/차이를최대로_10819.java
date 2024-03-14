package jchang._0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차이를최대로_10819 {
  static int[] input;
  static int[] temp;
  static int N;
  static int max = 0;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    input = new int[N];
    temp = new int[N];
    visited = new boolean[N];
    for (int i = 0; i < N; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }

    dfs(0);
    System.out.println(max);
  }

  private static void dfs(int idx) {
    if (idx == N) {
      int sum = 0;
      for (int i = 0; i < N - 1; i++) {
        sum += Math.abs(temp[i] - temp[i + 1]);
      }
      max = Math.max(max, sum);
      return;
    }

    for (int i = 0; i < input.length ; i++) {
      if (!visited[i]) {
        temp[idx] = input[i];
        visited[i] = true;
        dfs(idx + 1);
        visited[i] = false;
      }
    }
  }

}
