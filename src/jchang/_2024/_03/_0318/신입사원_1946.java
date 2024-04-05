package jchang._2024._03._0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 신입사원_1946 {

  static int T;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {

      int apply = Integer.parseInt(br.readLine());
      Node[] nodes = new Node[apply];
      for (int k = 0; k < apply; k++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int document = Integer.parseInt(st.nextToken());
        int interview = Integer.parseInt(st.nextToken());
        nodes[k] = new Node(document, interview);
      }

      Arrays.sort(nodes);

      int ans = 1;
      Node min = nodes[0];
      for (int j = 1; j < nodes.length; j++) {
        Node cur = nodes[j];
        if (cur.interview < min.interview) {
          ans++;
          min = cur;
        }
      }

      sb.append(ans).append("\n");
    }

    System.out.println(sb);

  }



  static class Node implements Comparable<Node>{
    int document;
    int interview;
    public Node(int document, int interview) {
      this.document = document;
      this.interview = interview;
    }



    @Override
    public int compareTo(Node o) {
      return Integer.compare(document, o.document);
    }
  }

}
