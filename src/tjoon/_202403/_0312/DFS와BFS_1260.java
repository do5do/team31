package tjoon._202403._0312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS_1260 {

  static int n, m, v;
  static int[][] matrix;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    v = Integer.parseInt(st.nextToken());

    matrix = new int[n + 1][n + 1];
    visited = new boolean[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      matrix[a][b] = matrix[b][a] = 1;
    }

    dfs(v);
    System.out.println();

    visited = new boolean[n + 1];
    bfs(v);

  }

  private static void dfs(int start) {

    System.out.print(start + " ");

    visited[start] = true;

    for (int i = 1; i < n + 1; i++) {
      if (matrix[start][i] == 1 && !visited[i]) {
        dfs(i);
      }
    }
  }

  private static void bfs(int start) {

    Queue<Integer> queue = new LinkedList<>();
    List<Integer> list = new ArrayList<>();
    queue.offer(start);
    list.add(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      for (int i = 1; i < matrix[cur].length; i++) {
        if (matrix[cur][i] == 1 && !visited[i]) {
          visited[i] = true;
          queue.offer(i);
          list.add(i);
        }
      }
    }

    for (int value : list) {
      System.out.print(value + " ");
    }

  }

}
