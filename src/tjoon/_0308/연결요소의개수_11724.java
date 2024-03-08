package tjoon._0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연결요소의개수_11724 {

  static int[][] graph;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    graph = new int[n + 1][n + 1];
    visited = new boolean[n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int num1 = Integer.parseInt(st.nextToken());
      int num2 = Integer.parseInt(st.nextToken());

      graph[num1][num2] = 1;
      graph[num2][num1] = 1;
    }

    int count = 0;
    for (int i = 1; i < n + 1; i++) {
      if (!visited[i]) {
        dfs(i);
        count++;
      }
    }

    System.out.println(count);

  }

  private static void dfs(int num) {
    if (visited[num]) {
      return;
    }

    visited[num] = true;

    for (int i = 0; i < graph.length; i++) {
      if (graph[num][i] == 1) {
        dfs(i);
      }

    }

  }


}
