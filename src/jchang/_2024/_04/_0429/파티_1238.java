package jchang._2024._04._0429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티_1238 {
  static int n, m, x;
  static ArrayList<ArrayList<Node>> list, reverseList;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());

    list = new ArrayList<>();
    reverseList = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      list.add(new ArrayList<>());
      reverseList.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      list.get(start).add(new Node(end, weight));
      reverseList.get(end).add(new Node(start, weight));
    }

    int[] fromX = dijkstra(list);
    int[] toX = dijkstra(reverseList);

    int answer = 0;
    for (int i = 1; i <= n; i++) {
      answer = Math.max(answer, fromX[i] + toX[i]);
    }
    System.out.println(answer);
  }

  private static int[] dijkstra(ArrayList<ArrayList<Node>> list) {
    PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {
        return o1.weight - o2.weight;
      }
    });
    pq.offer(new Node(x, 0));

    int[] dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[x] = 0;
    boolean[] visited = new boolean[n + 1];


    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (!visited[cur.end]) {
        visited[cur.end] = true;
        for (Node node : list.get(cur.end)) {
          if (!visited[node.end] && dist[cur.end] + node.weight < dist[node.end]) {
            dist[node.end] = dist[cur.end] + node.weight;
            pq.offer(new Node(node.end, dist[node.end]));
          }
        }
      }
    }
    return dist;
  }

  static class Node{
    int end, weight;
    public Node(int end, int weight) {
      this.end = end;
      this.weight = weight;
    }
  }
}
