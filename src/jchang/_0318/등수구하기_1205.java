package jchang._0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등수구하기_1205 {

  static int N;
  static int myScore;
  static int P;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st1.nextToken());
    myScore = Integer.parseInt(st1.nextToken());
    P = Integer.parseInt(st1.nextToken());

    Node[] rank = new Node[P];
    int result = -1;
    if (N != 0) {
      StringTokenizer st2 = new StringTokenizer(br.readLine());

      for (int i = 0; i < N; i++) {
        int score = Integer.parseInt(st2.nextToken());
        boolean flag = false;
        if (myScore > score) {
          score = myScore;
          flag = true;
        }
        Node cur;
        if (i != 0 && score == rank[i - 1].score) {
          cur = new Node(score, rank[i - 1].ranking);
        } else {
          cur = new Node(score, i + 1);
        }
        rank[i] = cur;
        if (flag) {
          result = cur.ranking;
          break;
        }
      }
    }

    if (N == 0) {
      result = 1;
    } else if (N < P && result == -1) {
      if (rank[N-1].score == myScore) {
        result = rank[N-1].ranking;
      } else {
        result = N + 1;
      }

    }

    System.out.println(result);

  }

  static class Node{
    int score;
    int ranking;
    public Node(int score, int ranking) {
      this.score = score;
      this.ranking = ranking;
    }
  }

}
