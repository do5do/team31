package jchang._2024._04._0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지_4485 {
  static int[] dx = new int[]{-1, 1, 0, 0};
  static int[] dy = new int[]{0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean isEnd = false;
    StringBuilder sb = new StringBuilder();
    int stage = 0;
    while (!isEnd) {
      stage++;
      int n = Integer.parseInt(br.readLine());
      if (n == 0) {
        isEnd = true;
        continue;
      }

      int[][] board = new int[n][n];
      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          int a = Integer.parseInt(st.nextToken());
          board[i][j] = a;
        }
      }

      int result = bfs(n, board);

      sb.append("Problem ").append(stage).append(": ").append(result).append("\n");

    }

    System.out.println(sb);
  }

  private static int bfs(int n, int[][] board) {
    int[][] dp = new int[n][n];

    for (int[] ints : dp) {
      Arrays.fill(ints, Integer.MAX_VALUE);
    }

    dp[0][0] = board[0][0];

    Queue<Node> q = new LinkedList<>();

    q.add(new Node(0, 0, board[0][0]));

    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int i = 0; i < dx.length; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
          continue;
        }

        if (dp[cur.x][cur.y] + board[nx][ny] < dp[nx][ny]) {
          dp[nx][ny] = dp[cur.x][cur.y] + board[nx][ny];
          q.add(new Node(nx, ny, board[nx][ny]));
        }
      }
    }

    return dp[n - 1][n - 1];
  }

  static class Node {
    int x, y, weight;

    public Node(int x, int y, int weight) {
      this.x = x;
      this.y = y;
      this.weight = weight;
    }
  }

}
