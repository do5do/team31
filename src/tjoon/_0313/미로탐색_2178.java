package tjoon._0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178 {

  static char[][] board;
  static int[][] count;
  static int[] di = {0, 0, 1, -1};
  static int[] dj = {1, -1, 0, 0};
  static int n, m;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new char[n][m];
    count = new int[n][m];

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      board[i] = s.toCharArray();
    }

    bfs();

  }

  private static void bfs() {

    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(0, 0));
    count[0][0] = 1;

    while (!queue.isEmpty()) {
      Node cur = queue.poll();

      for (int d = 0; d < 4; d++) {
        int nx = cur.i + di[d];
        int ny = cur.j + dj[d];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
          if (board[nx][ny] == '1' && count[nx][ny] == 0) {
            queue.offer(new Node(nx, ny));
            count[nx][ny] = count[cur.i][cur.j] + 1;
          }
        }
      }
    }

    System.out.println(count[n - 1][m - 1]);
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
