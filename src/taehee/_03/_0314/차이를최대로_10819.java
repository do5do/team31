package taehee._03._0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 차이를최대로_10819 {

  static int N;
  static int[] A;
  static boolean[] visited;
  static int[] compose;

  static int MAX = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    A = new int[N];
    compose = new int[N];
    visited = new boolean[N];
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(tokenizer.nextToken());
    }

    dfs(0);

    System.out.println(MAX);
  }

  static void dfs(int cur) {
    if (cur == N) {
      MAX = Math.max(MAX, sum());
      return;
    }

    for (int i = 0; i < A.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        compose[cur] = A[i];
        dfs(cur + 1);
        visited[i] = false;
      }
    }
  }

  static int sum() {
    int sum = 0;
    for (int i = 0; i < N - 1; i++) {
      sum += Math.abs(compose[i] - compose[i+1]);
    }
    return sum;
  }
}
