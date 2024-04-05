package jchang._2024._03._0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정_1931 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Node[] nodes = new Node[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      nodes[i] = new Node(start, end);
    }

    Arrays.sort(nodes);
    int count = 1;
    Node min = nodes[0];
    for (int i = 1; i < nodes.length; i++) {
      Node cur = nodes[i];
      if (cur.start >= min.end) {
        count++;
        min = cur;
      }
    }

    System.out.println(count);
  }

  static class Node implements Comparable<Node>{
    int start;
    int end;
    public Node(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Node o) {
      if (this.end == o.end) {
        return this.start - o.start;
      }
      return this.end - o.end;
    }
  }
}
