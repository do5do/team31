package jchang._2024._05._0522;

import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;
    import java.util.StringTokenizer;

public class 그래프트리분할_22954 {
  static int n, m;
  static List<Node>[] graph;
  static boolean[] visited;
  static List<Integer>[] nodesInTree;
  static List<Integer>[] edgesInTree;
  static int treeIdx = 0;
  static boolean[] isLeaf;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    if (n <= 2) {
      System.out.println(-1);
      return;
    }

    graph = new List[n + 1];
    for (int i = 0; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 1; i <= m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph[a].add(new Node(b, i));
      graph[b].add(new Node(a, i));
    }

    nodesInTree = new List[n];
    for (int i = 0; i < n; i++) {
      nodesInTree[i] = new ArrayList<>();
    }

    edgesInTree = new List[n];
    for (int i = 0; i < n; i++) {
      edgesInTree[i] = new ArrayList<>();
    }

    visited = new boolean[n + 1];
    isLeaf = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
      if (!visited[i]) {
        dfs(i);
        treeIdx++;
      }
    }

    if (treeIdx > 2) {
      System.out.println(-1);
      return;
    } else if (treeIdx == 2) {
      if (nodesInTree[0].size() == nodesInTree[1].size()) {
        System.out.println(-1);
        return;
      } else {
        print();
      }
    } else {
      int leaf = 0;
      int start = 0;
      for (int node : nodesInTree[0]) {
        if (isLeaf[node]) {
          leaf = node;
        } else {
          start = node;
        }
      }

      visited = new boolean[n + 1];
      visited[leaf] = true;
      nodesInTree[1].add(leaf);

      nodesInTree[0].clear();
      edgesInTree[0].clear();
      treeIdx = 0;
      dfs(start);

      print();
    }

    System.out.println(sb);
  }

  private static void print() {
    Collections.sort(nodesInTree[0]);
    Collections.sort(nodesInTree[1]);
    Collections.sort(edgesInTree[0]);
    Collections.sort(edgesInTree[1]);

    sb.append(nodesInTree[0].size()).append(" ").append(nodesInTree[1].size());
    sb.append("\n");

    for (int i = 0; i <= 1; i++) {
      for (int n : nodesInTree[i]) {
        sb.append(n).append(" ");
      }
      sb.append("\n");

      for (int n : edgesInTree[i]) {
        sb.append(n).append(" ");
      }
      sb.append("\n");
    }

  }

  private static void dfs(int start) {
    visited[start] = true;
    nodesInTree[treeIdx].add(start);
    boolean leaf = true;
    for (Node node : graph[start]) {
      if (!visited[node.edgeTo]) {
        edgesInTree[treeIdx].add(node.edgeNo);
        dfs(node.edgeTo);
        leaf = false;
      }
    }

    isLeaf[start] = leaf;
  }

  public static class Node{
    int edgeTo, edgeNo;
    public Node(int edgeTo, int edgeNo) {
      this.edgeTo = edgeTo;
      this.edgeNo = edgeNo;
    }
  }
}
