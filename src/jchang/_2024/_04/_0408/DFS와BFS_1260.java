package jchang._2024._04._0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS_1260 {

  static int n;
  static int m;
  static int start;
  static int[][] board;
  static boolean[] visited;
  static StringBuilder sb;
  public static void main(String[] args) throws IOException {
    sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    start = Integer.parseInt(st.nextToken());

    board = new int[n + 1][n + 1];
    visited = new boolean[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      board[a][b] = 1;

    }

    dfs(start);
    sb.append("\n");
    bfs(start);
  }

  private static void dfs(int start) {
    visited[start] = true;
    sb.append(start).append(" ");


    for (int i = 1; i <= n; i++) {
      if (!visited[i] && (board[start][i] == 1 || board[i][start] == 1)) {
        dfs(i);
      }
    }
  }

  private static void bfs(int start) {
    visited = new boolean[n + 1];

    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    sb.append(start).append(" ");
    visited[start] = true;

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int i = 1; i < board.length; i++) {
        if ((board[cur][i] == 1 || board[i][cur] == 1) && !visited[i]) {
          visited[i] = true;
          sb.append(i).append(" ");
          q.add(i);
        }
      }
    }

    System.out.println(sb);
  }
}
