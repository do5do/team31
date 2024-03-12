package taehee._0312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS_1260 {

  static int vertex, edge, start;

  static Queue<Integer>[] graph_dfs;
  static Queue<Integer>[] graph_bfs;
  static boolean[] visited_dfs;
  static boolean[] visited_bfs;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    vertex = Integer.parseInt(tokenizer.nextToken());
    edge = Integer.parseInt(tokenizer.nextToken());
    start = Integer.parseInt(tokenizer.nextToken());

    graph_dfs = new PriorityQueue[vertex + 1];
    graph_bfs = new PriorityQueue[vertex + 1];
    visited_dfs = new boolean[vertex + 1];
    visited_bfs = new boolean[vertex + 1];
    for (int i = 0; i < vertex + 1; i++) {
      graph_dfs[i] = new PriorityQueue<>();
      graph_bfs[i] = new PriorityQueue<>();
    }

    for (int i = 0; i < edge; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(tokenizer.nextToken());
      int e = Integer.parseInt(tokenizer.nextToken());
      graph_dfs[s].add(e);
      graph_dfs[e].add(s);

      graph_bfs[s].add(e);
      graph_bfs[e].add(s);
    }

    dfs(start);
    System.out.println();
    bfs();
  }

  static void dfs(int v) {
    if (visited_dfs[v]) {
      return;
    }

    visited_dfs[v] = true;
    System.out.print(v + " ");

    while (!graph_dfs[v].isEmpty()) {
      dfs(graph_dfs[v].poll());
    }
  }

  static void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);

    while (!queue.isEmpty()) {
      Integer node = queue.poll();

      if (visited_bfs[node]) {
        continue;
      }
      visited_bfs[node] = true;
      System.out.print(node + " ");

      while (!graph_bfs[node].isEmpty()) {
        queue.add(graph_bfs[node].poll());
      }
    }

    System.out.println();
  }
}
