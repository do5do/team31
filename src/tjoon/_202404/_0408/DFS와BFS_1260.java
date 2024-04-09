package tjoon._202404._0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS_1260 {

  static int n, m, v;
  static int[][] matrix;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken()); // 정점개수
    m = Integer.parseInt(st.nextToken()); // 간선개수
    v = Integer.parseInt(st.nextToken()); // 시작노드

    matrix = new int[n + 1][n + 1];
    visited = new boolean[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      matrix[a][b] = matrix[b][a] = 1;
    }

    dfs(v);
    sb.append("\n");

    visited = new boolean[n + 1];
    bfs(v);

    System.out.println(sb);

  }

  private static void dfs(int start) {

    sb.append(start).append(" ");
    visited[start] = true;

    for (int i = 1; i < n + 1; i++) {
      if (matrix[start][i] == 1 && !visited[i]) {
        dfs(i);
      }
    }

  }

  private static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    sb.append(start).append(" ");
    visited[start] = true;

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      for (int i = 1; i < n + 1; i++) {
        if (matrix[cur][i] == 1 && !visited[i]) {
          visited[i] = true;
          queue.add(i);
          sb.append(i).append(" ");
        }
      }
    }
  }

}
