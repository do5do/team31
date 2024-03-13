package jchang._0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동_7562 {
  static int N;
  static int[] dx;
  static int[] dy;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    dx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
    dy = new int[]{1, -1, 2, -2, 2, -2, 1, -1};

    for (int i = 0; i < N; i++) {
      int I = Integer.parseInt(br.readLine());
      Node start = null;
      Node end = null;
      for (int j = 0; j < 2; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        if (j == 0) {
          start = new Node(x, y);
        } else {
          end = new Node(x, y);
        }
      }
      solve(I, start, end);
      System.out.println();
    }
  }

  private static void solve(int I, Node start, Node end) {
    int[][] matrix = new int[I][I];
    matrix[start.x][start.y] = 1;

    Queue<Node> q = new LinkedList<>();
    q.add(start);

    while (!q.isEmpty()) {
      Node cur = q.poll();
      int x = cur.x;
      int y = cur.y;

      if (x == end.x && y == end.y) {
        System.out.print(matrix[x][y] - 1);
        return;
      }
      
      int nx;
      int ny;
      for (int i = 0; i < dx.length; i++) {
        nx = x + dx[i];
        ny = y + dy[i];

        if (nx < 0 || ny < 0 || nx >= I || ny >= I) {
          continue;
        }

        if (matrix[nx][ny] == 0) {
          matrix[nx][ny] = matrix[x][y] + 1;
          q.add(new Node(nx, ny));
        }

      }
    }

  }

  static class Node{
    int x;
    int y;
    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
