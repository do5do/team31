package jchang._2024._04._0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구이동_16234 {

  static int[][] board;
  static int n;
  static int l;
  static int r;
  static boolean[][] visited;
  static int[] dx = new int[]{0, 0, -1, 1};
  static int[] dy = new int[]{-1, 1, 0, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    l = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    visited = new boolean[n][n];
    board = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int stage = 0;
    for (int i = 0; i <= 2000; i++) {
      if (!bfs()) {
        stage = i;
        break;
      }
    }

    System.out.println(stage);
  }

  private static boolean bfs() {
    boolean move = false;
    visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j]) {
          continue;
        }
        visited[i][j] = true;
        Queue<Node> q = new LinkedList<>();
        List<Node> listForAverage = new ArrayList<>();
        q.add(new Node(i, j, board[i][j]));
        int sum = board[i][j];
        while (!q.isEmpty()) {
          Node cur = q.poll();
          listForAverage.add(cur);

          int nx;
          int ny;
          for (int k = 0; k < dx.length; k++) {
            nx = cur.x + dx[k];
            ny = cur.y + dy[k];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
              continue;
            }

            int differance = Math.abs(board[cur.x][cur.y] - board[nx][ny]);
            if (differance >= l && differance <= r && !visited[nx][ny]) {
              visited[nx][ny] = true;
              q.add(new Node(nx, ny, board[nx][ny]));
              sum += board[nx][ny];
              move = true;
            }
          }

        }

        for (Node node : listForAverage) {
          board[node.x][node.y] = sum / listForAverage.size();
        }
      }
    }

    return move;
  }

  static class Node{
    int x, y, population;
    public Node(int x, int y, int population) {
      this.x = x;
      this.y = y;
      this.population = population;
    }
  }
}
