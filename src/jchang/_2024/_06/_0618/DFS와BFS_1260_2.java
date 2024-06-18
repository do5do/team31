package jchang._2024._06._0618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class DFS와BFS_1260_2 {
  // DFS, BFS 탐색 결과 출력
  // 방문할 정점 여러 개인 경우 정점 번호가 작은 것 먼저 방문
  // 방문할 정점이 더이상 없는 경우 종료
  // 정점번호 1 ~ N
  static int n, m, v;
  static boolean[] visited;
  static List<Set<Integer>> graph;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    v = Integer.parseInt(st.nextToken());
    visited = new boolean[n + 1];

    graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new TreeSet<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    sb.append(v).append(" ");
    dfs(v, 0);
    sb.append("\n");
    bfs();

    System.out.println(sb);
  }

  private static void dfs(int start, int depth) {
    visited[start] = true;

    if (depth == n - 1) {
      return;
    }

    Set<Integer> set = graph.get(start);
    for (Integer num : set) {
      if (!visited[num]) {
        sb.append(num).append(" ");
        dfs(num, depth + 1);
      }
    }
  }

  private static void bfs() {
    visited = new boolean[n + 1];
    visited[v] = true;
    Queue<Integer> q = new LinkedList<>();

    q.add(v);

    while (!q.isEmpty()) {
      int cur = q.poll();
      sb.append(cur).append(" ");

      Set<Integer> set = graph.get(cur);
      for (Integer num : set) {
        if (!visited[num]) {
          visited[num] = true;
          q.add(num);
        }
      }
    }
  }
}
