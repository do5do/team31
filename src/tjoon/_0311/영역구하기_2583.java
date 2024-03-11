package tjoon._0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 영역구하기_2583 {

  static int[][] board;
  static boolean[][] visited;
  static int m, n, k;
  static int count;
  static int[] di = {0, 0, 1, -1};
  static int[] dj = {1, -1, 0, 0};
  static List<Integer> countList = new ArrayList<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    board = new int[m][n];
    visited = new boolean[m][n];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      for (int y = y1; y < y2; y++) {
        for (int x = x1; x < x2; x++) {
          board[y][x] = 1;
        }
      }

    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 0 && !visited[i][j]) {
          dfs(i, j);
          countList.add(count);
          count = 0;
        }
      }
    }

    Collections.sort(countList);

    System.out.println(countList.size());
    for (int value : countList) {
      System.out.print(value + " ");
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

      if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
        if (board[nx][ny] == 0) {
          dfs(nx, ny);
        }
      }
    }
  }

}
