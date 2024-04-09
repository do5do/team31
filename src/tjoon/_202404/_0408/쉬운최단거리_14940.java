package tjoon._202404._0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리_14940 {

  static int n, m;
  static int[][] board;
  static int[][] count;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n][m];
    count = new int[n][m];

    int x = 0;
    int y = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        if (board[i][j] == 2) {
          x = i;
          y = j;
        }
      }
    }

    bfs(x, y);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 1 && count[i][j] == 0) {
          sb.append(-1).append(" ");
        } else {
          sb.append(count[i][j]).append(" ");
        }
      }
      sb.append("\n");
    }

    System.out.println(sb);

  }

  private static void bfs(int x, int y) {
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(x, y));

    while (!queue.isEmpty()) {
      Node cur = queue.poll();

      for (int d = 0; d < 4; d++) {
        int nx = cur.x + dx[d];
        int ny = cur.y + dy[d];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
          if (board[nx][ny] == 1 && count[nx][ny] == 0) {
            queue.offer(new Node(nx, ny));
            count[nx][ny] = count[cur.x][cur.y] + 1;
          }
        }
      }
    }
  }

  static class Node {

    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

}
