package tjoon._202403._0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지번호붙이기_2667 {

  static char[][] board;
  static boolean[][] visited;
  static int[] di = {0, 0, 1, -1};
  static int[] dj = {1, -1, 0, 0};

  static int count = 0;
  static List<Integer> countList = new ArrayList<>();

  static int n;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    board = new char[n][n];
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      String s = br.readLine();

      for (int j = 0; j < s.length(); j++) {
        board[i][j] = s.charAt(j);
      }

    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == '1' && !visited[i][j]) {
          dfs(i, j);
          countList.add(count);
          count = 0;
        }
      }
    }

    Collections.sort(countList);

    System.out.println(countList.size());
    for (int value : countList) {
      System.out.println(value);
    }

  }

  private static void dfs(int x, int y) {

    if (visited[x][y]) {
      return;
    }

    visited[x][y] = true;
    count++;

    for (int d = 0; d < 4; d++) {
      int nx = x + di[d];
      int ny = y + dj[d];

      if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
        if (board[nx][ny] == '1') {
          dfs(nx, ny);
        }
      }
    }
  }
}
