package jchang._2024._04._0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] distance = new int[100001];
    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[n] = 0;

    if (k <= n) {
      System.out.println(n - k);
      System.exit(0);
    }

    PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {
        return o1.cost - o2.cost;
      }
    });

    pq.add(new Node(n, 0));
    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      int nx;
      int cost;

      nx = cur.x + 1;
      cost = cur.cost + 1;
      if (nx < distance.length && cost < distance[nx]) {
        distance[nx] = cost;
        pq.add(new Node(nx, cost));
      }

      nx = cur.x - 1;
      cost = cur.cost + 1;
      if (nx >= 0 && cost < distance[nx]) {
        distance[nx] = cost;
        pq.add(new Node(nx, cost));
      }

      nx = 2 * cur.x;
      cost = cur.cost;
      if (nx < distance.length && cost < distance[nx]) {
        distance[nx] = cost;
        pq.add(new Node(nx, cost));
      }
    }

    System.out.println(distance[k]);

  }

  static class Node{
    int x, cost;
    public Node(int x, int cost) {
      this.x = x;
      this.cost = cost;
    }
  }

  // 최초 풀이 성공했으나 찝찝
//  public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());
//
//    int n = Integer.parseInt(st.nextToken());
//    int k = Integer.parseInt(st.nextToken());
//    if (n == k) {
//      System.out.println(0);
//      System.exit(0);
//    }
//
//    int[] board = new int[100002];
//    for (int i = 0; i < n; i++) {
//      board[i] = n - i;
//      if (i == k) {
//        System.out.println(board[i]);
//        System.exit(0);
//      }
//    }
//
//    for (int i = n + 1; i < board.length; i++) {
//      int a = board[i - 1] + 1;
//      int b = i % 2 == 0 ? board[i / 2] : Math.min(board[i / 2] + 1, board[(i + 1) / 2] + 1) ;
//
//      board[i] = Math.min(a, b);
//
//      if (i == k) {
//        System.out.println(board[i]);
//        System.exit(0);
//      }
//    }
//  }
}
