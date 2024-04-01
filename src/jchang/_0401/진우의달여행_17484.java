package jchang._0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 진우의달여행_17484 {

  static int n;
  static int m;
  static int[][] board;
  static int[] result;
  static int[] dx = new int[]{-1, 0, 1};
  static int min = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n][m];
    result = new int[n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < m; i++) {

      dfs(0, -2, i);
    }

    System.out.println(min);
  }

  private static void dfs(int idx, int beforeDirection, int x) {
    if (idx == n) {
      min = Math.min(Arrays.stream(result).sum(), min);
      return;
    }

    result[idx] = board[idx][x];
    for (int j : dx) {
      if (beforeDirection != j) {
        int nx = x + j;
        if (nx >= 0 && nx < m) {
          dfs(idx + 1, j, nx);
        }
      }
    }

  }
}
