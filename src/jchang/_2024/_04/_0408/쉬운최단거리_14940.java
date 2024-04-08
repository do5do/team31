package jchang._2024._04._0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리_14940 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] board = new int[n][m];
    Queue<Node> q = new LinkedList<>();
    int[][] dp = new int[n][m];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        int a = Integer.parseInt(st.nextToken());
        board[i][j] = a;
        if (a == 2) {
          Node target = new Node(i, j);
          q.add(target);
          dp[i][j] = 0;
        }

        if (a == 0) {
          dp[i][j] = 0;
        }
      }
    }

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    while (!q.isEmpty()) {
      Node cur = q.poll();
      int x = cur.x;
      int y = cur.y;

      for (int i = 0; i < dx.length; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
          continue;
        }

        if (board[nx][ny] == 1 && dp[nx][ny] == -1) {
          dp[nx][ny] = dp[x][y] + 1;
          q.add(new Node(nx, ny));
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(dp[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);


  }

  static class Node {
    int x, y;
    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
