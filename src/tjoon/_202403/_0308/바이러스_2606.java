package tjoon._202403._0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스_2606 {

  static int[][] graph;
  static boolean[] visited;
  static int count = 0;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    graph = new int[n + 1][n + 1];
    visited = new boolean[n + 1];

    for (int i = 0; i < k; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a][b] = 1;
      graph[b][a] = 1;
    }

    dfs(1);
    System.out.println(count - 1); // 1일때도 세어줌
  }

  private static void dfs(int num) {
    if (visited[num]) {
      return;
    }

    visited[num] = true;
    count++;

    for (int i = 0; i < graph.length; i++) {
      if (graph[num][i] == 1) {
        dfs(i);
      }

    }

  }

}
