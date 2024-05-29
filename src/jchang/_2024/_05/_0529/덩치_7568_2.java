package jchang._2024._05._0529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덩치_7568_2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int weight = Integer.parseInt(st.nextToken());
      int height = Integer.parseInt(st.nextToken());
      nodes[i] = new Node(weight, height);
    }

    for (int i = 0; i < nodes.length; i++) {
      int count = 0;
      for (int j = 0; j < nodes.length; j++) {
        if (nodes[j].weight > nodes[i].weight && nodes[j].height > nodes[i].height) {
          count++;
        }
      }
      nodes[i].rank = count + 1;
    }

    StringBuilder sb = new StringBuilder();
    for (Node node : nodes) {
      sb.append(node.rank).append(" ");
    }

    System.out.println(sb);
  }

  public static class Node {
    int weight, height, rank;
    public Node(int weight, int height) {
      this.weight = weight;
      this.height = height;
    }
  }
}
