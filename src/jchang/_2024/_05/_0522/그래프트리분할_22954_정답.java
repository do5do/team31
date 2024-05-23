package jchang._2024._05._0522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 그래프트리분할_22954_정답 {

  static int N, M; // 1 <= N <= 100,000 / 0 <= M <= 200,000
  static int s, e;
  static List<Node>[] graph;
  static boolean[] visited;
  static boolean[] isLeaf;
  static List<Integer>[] nodes;
  static List<Integer>[] edges;
  static int treeCnt = 0;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    if (N <= 2) {
      System.out.println(-1);
      return;
    }

    graph = new List[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }
    isLeaf = new boolean[N + 1];
    visited = new boolean[N + 1];

    nodes = new List[N + 1];
    for (int i = 0; i <= N; i++) {
      nodes[i] = new ArrayList<>();
    }

    edges = new List[N + 1];
    for (int i = 0; i <= N; i++) {
      edges[i] = new ArrayList<>();
    }

    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      s = Integer.parseInt(st.nextToken());
      e = Integer.parseInt(st.nextToken());

      graph[s].add(new Node(e, i));
      graph[e].add(new Node(s, i));
    }

    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        dfs(i, treeCnt);
        treeCnt++;
      }
    }

    if (treeCnt > 2) {
      sb.append(-1);
    } else if (treeCnt == 2) {
      if (nodes[0].size() == nodes[1].size()) {
        sb.append(-1);
      } else {
        print();
      }
    } else {
      int leaf = 0;
      int start = 0;
      for (int node : nodes[0]) {
        if (isLeaf[node]) {
          leaf = node;
        } else {
          start =  node;
        }
      }

      visited = new boolean[N + 1];
      visited[leaf] = true;
      nodes[1].add(leaf);

      nodes[0].clear();
      edges[0].clear();
      dfs(start, 0);

      print();
    }

    System.out.println(sb);
  }

  public static void print() {

    Collections.sort(nodes[0]);
    Collections.sort(nodes[1]);
    Collections.sort(edges[0]);
    Collections.sort(edges[1]);

    sb.append(nodes[0].size()).append(" ").append(nodes[1].size()).append("\n");

    for (int i = 0; i <= 1; i++) {
      for (int node : nodes[i]) {
        sb.append(node).append(" ");
      }
      sb.append("\n");
      for (int edge : edges[i]) {
        sb.append(edge).append(" ");
      }
      sb.append("\n");
    }
  }

  public static void dfs(int start, int idx) {
    visited[start] = true;
    nodes[idx].add(start);
    boolean leaf = true;
    for (Node node : graph[start]) {
      if (!visited[node.e]) {
        edges[idx].add(node.no);
        dfs(node.e, idx);
        leaf = false;
      }
    }

    isLeaf[start] = leaf;
  }

  public static class Node {
    int e;
    int no;

    public Node(int e, int no) {
      this.e = e;
      this.no = no;
    }
  }
}