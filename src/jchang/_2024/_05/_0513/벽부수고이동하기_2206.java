package jchang._2024._05._0513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_2206 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] board = new int[n][m];
    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < m; j++) {
        board[i][j] = str.charAt(j) - '0';
      }
    }

    boolean[][][] visited = new boolean[n][m][2];


    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(0, 0, false, 1));
    visited[0][0][0] = true;

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    while (!q.isEmpty()) {
      Node cur = q.poll();

      if (cur.x == n - 1 && cur.y == m - 1) {
        System.out.println(cur.count);
        return;
      }

      for (int i = 0; i < dx.length; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
          continue;
        }

        if (board[nx][ny] == 0) {
          if (!cur.broken && !visited[nx][ny][0]) {
            q.offer(new Node(nx, ny, false,cur.count + 1));
            visited[nx][ny][0] = true;
          } else if (cur.broken && !visited[nx][ny][1]) {
            q.offer(new Node(nx, ny, true, cur.count + 1));
            visited[nx][ny][1] = true;
          }
        } else {
          if (!cur.broken && !visited[nx][ny][1]) {
            q.offer(new Node(nx, ny, true, cur.count + 1));
            visited[nx][ny][1] = true;
          }
        }

      }

    }

    System.out.println(-1);
  }

  static class Node {
    int x, y;
    boolean broken;
    int count;
    public Node(int x, int y, boolean broken, int count) {
      this.x = x;
      this.y = y;
      this.broken = broken;
      this.count = count;
    }
  }
}
