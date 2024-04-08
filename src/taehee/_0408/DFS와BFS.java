package taehee._0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class DFS와BFS {

  static boolean[] visited;
  static List<SortedSet<Integer>> graph = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(tokenizer.nextToken());
    int M = Integer.parseInt(tokenizer.nextToken());
    int V = Integer.parseInt(tokenizer.nextToken());

    visited = new boolean[N + 1];

    for (int i = 0; i < visited.length; i++) {
      graph.add(new TreeSet<>());
    }

    for (int i = 0; i < M; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(tokenizer.nextToken());
      int e = Integer.parseInt(tokenizer.nextToken());
      graph.get(s).add(e);
      graph.get(e).add(s);
    }

    dfs(V);

    System.out.println();
    visited = new boolean[N + 1];

    bfs(V);
  }

  static void dfs(int v) {
    if (visited[v]) {
      return;
    }

    visited[v] = true;
    System.out.print(v + " ");

    for (int node : graph.get(v)) {
      dfs(node);
    }
  }


  static void bfs(int v) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(v);
    visited[v] = true;

    while (!queue.isEmpty()) {
      Integer poll = queue.poll();
      System.out.print(poll + " ");

      for (int node : graph.get(poll)) {
        if (!visited[node]) {
          queue.offer(node);
          visited[node] = true;
        }
      }
    }
    System.out.println();
  }
}
