package jchang._2024._06._0618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리_14940_2 {
  // 모든 지점에 대해 목표지점까지의 거리
  // 0은 갈 수 없는 땅, 1은 갈 수 있는 땅, 2는 목표지점
  // 원래 갈 수 없는 땅은 0 출력, 갈수 있는 땅인데 도달할 수 없으면 -1
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] map = new int[n][m];
    int[][] dp = new int[n][m];

    Node start = null;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());

        if (map[i][j] == 0) {
          dp[i][j] = 0;
        } else {
          if (map[i][j] == 2) {
            start = new Node(i, j);
          }
          dp[i][j] = -1;
        }
      }
    }

    dp[start.x][start.y] = 0;

    Queue<Node> q = new LinkedList<>();
    q.add(start);

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    while (!q.isEmpty()) {
      Node cur = q.poll();

      for (int i = 0; i < dx.length; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 0) {
          continue;
        }

        if (dp[nx][ny] == -1) {
          dp[nx][ny] = dp[cur.x][cur.y] + 1;
          q.add(new Node(nx, ny));
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        sb.append(dp[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  public static class Node{
    int x, y;
    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
