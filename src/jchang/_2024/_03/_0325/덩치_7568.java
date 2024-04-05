package jchang._2024._03._0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덩치_7568 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Node[] problem = new Node[N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      Node cur = new Node();
      cur.weight = Integer.parseInt(st.nextToken());
      cur.height = Integer.parseInt(st.nextToken());
      problem[i] = cur;
    }

    for (Node value : problem) {
      int rank = 1;
      Node pre;
      for (Node node : problem) {
        pre = node;
        if (pre.weight > value.weight && pre.height > value.height) {
          rank++;
        }
      }
      System.out.print(rank + " ");
    }


  }

  static class Node{
    int weight, height;
    public Node() {

    }
  }
}
