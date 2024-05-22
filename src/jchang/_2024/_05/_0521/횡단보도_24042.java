package jchang._2024._05._0521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 횡단보도_24042 {
  static int n, m;
  static List<List<Node>> crossWalk;
  static long[] distance;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    crossWalk = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      crossWalk.add(new ArrayList<>());
    }
    distance = new long[n + 1];
    Arrays.fill(distance, Long.MAX_VALUE);

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      crossWalk.get(a).add(new Node(b, i));
      crossWalk.get(b).add(new Node(a, i));
    }
    dijkstra();
    System.out.println(distance[n]);
  }

  private static void dijkstra() {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(1, 0));
    distance[1] = 0;

    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      if (cur.cost > distance[cur.index]) {
        continue;
      }

      for (Node next : crossWalk.get(cur.index)) {
        long nextCost;
        if (cur.cost <= next.cost) {
          nextCost = next.cost + 1;
        } else {
          nextCost = ((long) Math.ceil(((double) cur.cost - next.cost) / m)) * m + next.cost + 1;
        }

        if (nextCost < distance[next.index]) {
          distance[next.index] = nextCost;
          pq.offer(new Node(next.index, nextCost));
        }
      }
    }
  }

  private static class Node implements Comparable<Node> {
    int index;
    long cost;

    public Node(int index, long cost) {
      this.index = index;
      this.cost = cost;
    }


    @Override
    public int compareTo(Node o) {
      return Long.compare(this.cost, o.cost);
    }
  }
}
