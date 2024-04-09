package tjoon._202403._0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추_1012 {

  static int[][] board;
  static boolean[][] visited;
  static int count;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {

      count = 0;

      StringTokenizer st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken()); // 가로
      int n = Integer.parseInt(st.nextToken()); // 세로
      int k = Integer.parseInt(st.nextToken()); // 배추개수

      board = new int[m][n];
      visited = new boolean[m][n];

      for (int i = 0; i < k; i++) {
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        board[a][b] = 1;
      }

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (board[i][j] == 1 && !visited[i][j]) {
            dfs(i, j);
            count++;
          }
        }
      }

      System.out.println(count);


    }

  }

  private static void dfs(int x, int y) {

    if (visited[x][y]) {
      return;
    }

    visited[x][y] = true;

    int[] di = {-1, 1, 0, 0}; // 상 하 좌 우
    int[] dj = {0, 0, -1, 1};

    for (int d = 0; d < 4; d++) {
      int ni = x + di[d];
      int nj = y + dj[d];

      if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
        if (board[ni][nj] == 1) {
          dfs(ni, nj);
        }
      }
    }
  }

}