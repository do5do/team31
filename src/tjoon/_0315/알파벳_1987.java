package tjoon._0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_1987 {

  static int R, C;
  static int[][] alpha;
  static boolean[] visited = new boolean[26];
  static int[] di = {0, 0, 1, -1};
  static int[] dj = {1, -1, 0, 0};
  static int max = 0;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    alpha = new int[R][C];

    for (int i = 0; i < R; i++) {
      String s = br.readLine();
      for (int j = 0; j < C; j++) {
        alpha[i][j] = s.charAt(j) - 'A';
      }
    }

    dfs(0, 0, 1);

    System.out.println(max);

  }

  private static void dfs(int x, int y, int idx) {
    max = Math.max(max, idx);
    visited[alpha[x][y]] = true;

    for (int d = 0; d < 4; d++) {
      int nx = x + di[d];
      int ny = y + dj[d];

      if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
        if (!visited[alpha[nx][ny]]) {
          dfs(nx, ny, idx + 1);
          visited[alpha[nx][ny]] = false;
        }

      }
    }


  }
}
