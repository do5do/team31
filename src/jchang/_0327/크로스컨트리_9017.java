package jchang._0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 크로스컨트리_9017 {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      Node[] teams = new Node[201];
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] arrive = new int[N];

      for (int j = 0; j < N; j++) {
        int numOfTeam = Integer.parseInt(st.nextToken());
        arrive[j] = numOfTeam;
        if (teams[numOfTeam] == null) {
          Node node = new Node();
          node.teamNum = numOfTeam;
          teams[numOfTeam] = node;
        }

        Node node = teams[numOfTeam];
        node.total++;

      }

      int score = 0;
      List<Node> candidate = new ArrayList<>();
      for (int k : arrive) {
        Node node = teams[k];
        if (node.total == 6) {
          score++;
          node.count++;
          if (node.count <= 4) {
            node.score += score;
          }

          if (node.count == 5) {
            node.fifthScore = score;
          } else if (node.count == 6) {
            node.sixthScore = score;
          }
          candidate.add(node);
        }
      }

      candidate.sort(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
          if (o1.score == o2.score) {
            return o1.fifthScore - o2.fifthScore;
          }
          return o1.score - o2.score;
        }
      });
      Node winner = candidate.get(0);
      sb.append(winner.teamNum).append("\n");
    }

    System.out.println(sb);
  }

  static class Node {
    int teamNum;
    int total;
    int count;
    int score;
    int fifthScore;
    int sixthScore;

    public Node() {

    }
  }
}
