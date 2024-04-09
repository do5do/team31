package tjoon._202404._0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진우의달여행_17484 {

  static int N, M;
  static int[][] space;
  static int[] dy = {-1, 0, 1};
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    space = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        space[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int j = 0; j < M; j++) {
      dfs(0, j, -2, 0);
    }

    System.out.println(min);

  }

  private static void dfs(int x, int y, int usedDirection, int sum) {
    sum += space[x][y];

    if (x == (N - 1)) {
      min = Math.min(min, sum);
      return;
    }

    for (int d = 0; d < 3; d++) {
      if (usedDirection != dy[d]) {
        int nx = x + 1;
        int ny = y + dy[d];

        if (ny >= 0 && ny < M) {
          dfs(nx, ny, dy[d], sum);
        }
      }

    }
  }

}