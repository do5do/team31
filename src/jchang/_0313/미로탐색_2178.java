package jchang._0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178 {
  static int N;
  static int M;
  static int[][] matrix;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    matrix = new int[N][M];
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        matrix[i][j] = str.charAt(j) - '0';
      }
    }

    dp = new int[N][M];
    dp[0][0] = 1;
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(0, 0));
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    while (!q.isEmpty()) {
      Node cur = q.poll();
      int x = cur.x;
      int y = cur.y;

      int nx;
      int ny;
      for (int i = 0; i < dx.length; i++) {
        nx = x + dx[i];
        ny = y + dy[i];

        if (nx < 0 || ny < 0 || nx >= N || ny >= M || matrix[nx][ny] == 0) {
          continue;
        }

        if (matrix[nx][ny] == 1 && dp[nx][ny] == 0) {
          dp[nx][ny] = dp[x][y] + 1;
          q.add(new Node(nx, ny));
        }
      }
    }

    System.out.print(dp[N - 1][M - 1]);
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
