package jchang._0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보물섬_2589 {
  static int result = 0;
  static int N;
  static int M;
  static int[][] matrix;
  static int[] dx;
  static int[] dy;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    dx = new int[]{-1, 1, 0, 0};
    dy = new int[]{0, 0, 1, -1};

    matrix = new int[N][M];
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        if (str.charAt(j) == 'L') {
          matrix[i][j] = 1;
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (matrix[i][j] == 1) {
          solve(i, j);
        }
      }
    }
    System.out.print(result);
  }

  private static void solve(int xIndex, int yIndex) {
    int[][] dp = new int[N][M];
    dp[xIndex][yIndex] = 1;


    Queue<Node> q = new LinkedList<>();
    q.add(new Node(xIndex, yIndex));
    int maxDistance = 0;

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

        if (dp[nx][ny] == 0 ) {
          dp[nx][ny] = dp[x][y] + 1;
          maxDistance = Math.max(dp[nx][ny] - 1, maxDistance);
          q.add(new Node(nx, ny));
        }
      }
    }
    result = Math.max(maxDistance, result);
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
