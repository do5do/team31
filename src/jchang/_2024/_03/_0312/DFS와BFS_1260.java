package jchang._2024._03._0312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS_1260 {
  static int[][] arr;
  static int n;
  static int m;
  static int v;
  static boolean[] visited;
  static Queue<Integer> q;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    v = Integer.parseInt(st.nextToken());

    arr = new int[n + 1][n + 1];

    for (int i = 0; i < m; i++) {
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(tokenizer.nextToken());
      int b = Integer.parseInt(tokenizer.nextToken());
      arr[a][b] = 1;
      arr[b][a] = 1;
    }

    visited = new boolean[n + 1];
    dfs(v);

    System.out.println();

    q = new LinkedList<>();
    visited = new boolean[n + 1];
    bfs(v);

  }

  private static void dfs(int start) {
    visited[start] = true;
    System.out.print(start + " ");

    if (v == arr.length) {
      return;
    }

    for (int i = 1; i <= n ; i++) {
      if (arr[start][i] == 1 && !visited[i]) {
        dfs(i);
      }
    }
  }

  private static void bfs(int start) {
    q.add(start);
    visited[start] = true;
    System.out.print(start + " ");

    while (!q.isEmpty()) {
      int cur = q.poll();
      for (int i = 1; i <= n ; i++) {
        if (arr[cur][i] == 1 && !visited[i]) {
          q.add(i);
          visited[i] = true;
          System.out.print(i + " ");
        }
      }
    }
  }
}
