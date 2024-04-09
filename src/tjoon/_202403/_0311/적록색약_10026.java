package tjoon._202403._0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록색약_10026 {

  static String[][] board;
  static boolean[][] visited;
  static int[] di = {0, 0, -1, 1};
  static int[] dj = {-1, 1, 0, 0};
  static int normalCount = 0;
  static int colorCount = 0;
  static int n;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    board = new String[n][n];
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      String s = br.readLine();

      board[i] = s.split("");
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          dfs(i, j);
          normalCount++;
        }
      }
    }

    visited = new boolean[n][n]; // 초기화
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j].equals("R")) {
          board[i][j] = "G";
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          dfs(i, j);
          colorCount++;
        }
      }
    }

    System.out.println(normalCount + " " + colorCount);

  }

  static void dfs(int x, int y) {

    if (visited[x][y]) {
      return;
    }

    visited[x][y] = true;

    for (int d = 0; d < 4; d++) {
      int nx = x + di[d];
      int ny = y + dj[d];

      if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
        if (board[nx][ny].equals(board[x][y])) {
          dfs(nx, ny);
        }
      }
    }
  }

}
