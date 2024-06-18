package jchang._2024._06._0617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째큰수_2075_2 {
  // 모든 수는 자신의 한 칸 위에 있는 수보다 크다
  // N번째 큰 수를 찾아라
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] board = new int[n][n];
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
      }
    });
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
        pq.add(board[i][j]);
      }
    }

    for (int i = 1; i < n; i++) {
      pq.poll();
    }
    System.out.println(pq.poll());
  }
}
