package jchang._2024._07._0717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_2206_2 {
  // N x M 행렬
  // 0은 이동, 1은 이동 불가
  // 1, 1 --> N, M 의 최단 경로로 이동
  // 벽을 하나 깨부술수 있음
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] map = new int[n][m];
    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < m; j++) {
        map[i][j] = str.charAt(j) - '0';
      }
    }

    Queue<Node> q = new LinkedList<>();
    q.add(new Node(0, 0, false, 1));

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    boolean[][][] visited = new boolean[n][m][2];
    visited[0][0][0] = true;

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

        if (!cur.broken && map[nx][ny] == 1 && !visited[nx][ny][1]) {
          visited[nx][ny][1] = true;
          q.add(new Node(nx, ny, true, cur.count + 1));
        }

        if (map[nx][ny] == 0) {
          if (cur.broken && !visited[nx][ny][1]) {
            visited[nx][ny][1] = true;
          } else if (!cur.broken && !visited[nx][ny][0]) {
            visited[nx][ny][0] = true;
          } else {
            continue;
          }

          q.add(new Node(nx, ny, cur.broken, cur.count + 1));

        }
      }
    }

    System.out.println(-1);
  }

  public static class Node{
    int x, y, count;
    boolean broken;
    public Node(int x, int y, boolean broken, int count) {
      this.x = x;
      this.y = y;
      this.broken = broken;
      this.count = count;
    }
  }
}