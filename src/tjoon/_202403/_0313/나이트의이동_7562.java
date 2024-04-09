package tjoon._202403._0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동_7562 {

  static int n;
  static Node start;
  static Node end;
  static int[][] board;
  static int[][] count;
  static int[] di = {-2, -2, -1, 1, 2, 2, 1, -1};
  static int[] dj = {-1, 1, 2, 2, 1, -1, -2, -2};

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {

      // 코드 시작
      n = Integer.parseInt(br.readLine());

      for (int i = 0; i < 2; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (i == 0) {
          start = new Node(a, b);
        } else {
          end = new Node(a, b);
        }
      }

      board = new int[n][n];
      count = new int[n][n];

      System.out.println(bfs(start.i, start.j));

    }

  }

  private static int bfs(int x, int y) {
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(x, y));
    count[x][y] = 0;

    while (!queue.isEmpty()) {
      Node cur = queue.poll();

      if (cur.i == end.i && cur.j == end.j) {
        return count[end.i][end.j];
      }

      for (int d = 0; d < 8; d++) {
        int nx = cur.i + di[d];
        int ny = cur.j + dj[d];

        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
          if (count[nx][ny] == 0) {
            queue.offer(new Node(nx, ny));
            count[nx][ny] = count[cur.i][cur.j] + 1;
          }
        }
      }
    }

    return -1;

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
