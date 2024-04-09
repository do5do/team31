package tjoon._202403._0312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {

  static int[][] box;
  static int[] di = {0, 0, 1, -1};
  static int[] dj = {1, -1, 0, 0};
  static int m, n;
  static Queue<Tomato> queue = new LinkedList<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    box = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        box[i][j] = Integer.parseInt(st.nextToken());
        if (box[i][j] == 1) {
          queue.offer(new Tomato(i, j, 0));
        }
      }
    }

    bfs();

  }

  private static void bfs() {

    int day = 0;

    while (!queue.isEmpty()) {
      Tomato cur = queue.poll();
      day = cur.day;

      for (int d = 0; d < 4; d++) {

        int nx = cur.i + di[d];
        int ny = cur.j + dj[d];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
          if (box[nx][ny] == 0) {
            box[nx][ny] = 1;
            queue.offer(new Tomato(nx, ny, day + 1));
          }
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (box[i][j] == 0) {
          System.out.println(-1);
          System.exit(0);
        }
      }
    }

    System.out.println(day);

  }



  static class Tomato {
    int i;
    int j;
    int day;

    Tomato(int i, int j, int day) {
      this.i = i;
      this.j = j;
      this.day = day;
    }
  }

}
