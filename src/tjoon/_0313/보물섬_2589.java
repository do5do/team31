package tjoon._0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보물섬_2589 {

  static int n, m;
  static char[][] board;
  static int[][] count;
  static int[] di = {0, 0, 1, -1};
  static int[] dj = {1, -1, 0, 0};
  static int max = 0;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new char[n][m];

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      board[i] = s.toCharArray();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 'L') {
          count = new int[n][m];
          max = Math.max(bfs(i, j), max);
        }
      }
    }

    System.out.println(max);

  }

  private static int bfs(int x, int y) {

    int bfsMax = 0;

    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(x, y));
    count[x][y] = 1;

    while (!queue.isEmpty()) {
      Node cur = queue.poll();

      for (int d = 0; d < 4; d++) {
        int nx = cur.i + di[d];
        int ny = cur.j + dj[d];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
          if (board[nx][ny] == 'L' && count[nx][ny] == 0) {
            queue.offer(new Node(nx, ny));
            count[nx][ny] = count[cur.i][cur.j] + 1;
            bfsMax = Math.max(bfsMax, count[nx][ny]);
          }

        }
      }

    }

    return bfsMax - 1;

  }

  static class Node {

    int i;
    int j;

    Node(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }

}
