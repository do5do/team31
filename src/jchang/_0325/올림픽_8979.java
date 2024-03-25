package jchang._0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 올림픽_8979 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int target = Integer.parseInt(st.nextToken());
    Node[] board = new Node[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      Node cur = new Node();
      cur.national = Integer.parseInt(st.nextToken());
      cur.gold = Integer.parseInt(st.nextToken());
      cur.silver = Integer.parseInt(st.nextToken());
      cur.bronze = Integer.parseInt(st.nextToken());
      board[i] = cur;
    }

    Arrays.sort(board, new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {
        if (o1.gold - o2.gold == 0) {
          if (o1.silver - o2.silver == 0) {
            return o2.bronze - o1.bronze;
          }
          return o2.silver - o1.silver;
        }
        return o2.gold - o1.gold;
      }
    });

    board[0].order = 1;
    if (board[0].national == target) {
      System.out.print(1);
      System.exit(0);
    }

    for (int i = 1; i < board.length; i++) {
      Node pre = board[i - 1];
      Node cur = board[i];
      if (pre.gold == cur.gold && pre.silver == cur.silver && pre.bronze == cur.bronze) {
        cur.order = pre.order;
      } else {
        cur.order = i + 1;
      }

      if (cur.national == target) {
        System.out.print(cur.order);
        break;
      }
    }
  }

  static class Node{
    int national;
    int gold;
    int silver;
    int bronze;
    int order;
    public Node() {

    }
  }
}
