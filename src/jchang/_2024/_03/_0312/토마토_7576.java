package jchang._2024._03._0312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {
  static int M;
  static int N;
  static int[][] arr;
  static int[] dx;
  static int[] dy;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    arr = new int[N][M];

    Queue<Node> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(tokenizer.nextToken());
        if (arr[i][j] == 1) {
          q.add(new Node(i, j));
        }
      }
    }

    dx = new int[]{-1, 0, 1, 0};
    dy = new int[]{0, -1, 0, 1};

    while (!q.isEmpty()) {
      Node cur = q.poll();
      int x = cur.x;
      int y = cur.y;

      int nx;
      int ny;
      for (int j = 0; j < dx.length; j++) {
        nx = x + dx[j];
        ny = y + dy[j];

        if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == -1) {
          continue;
        }

        if (arr[nx][ny] == 0) {
          arr[nx][ny] = arr[x][y] + 1;
          q.add(new Node(nx, ny));
        }
      }
    }

    int max = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (arr[i][j] == 0) {
          System.out.print(-1);
          return;
        }
        max = Math.max(max, arr[i][j]);
      }
    }
    System.out.print(max - 1);

  }

  static class Node {
    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

}


