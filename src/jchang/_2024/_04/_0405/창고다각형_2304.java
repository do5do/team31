package jchang._2024._04._0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 창고다각형_2304 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] board = new int [1001];

    int max = 0;
    int maxIdx = -1;
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int idx = Integer.parseInt(st.nextToken());
      int height = Integer.parseInt(st.nextToken());
      board[idx] = height;
      if (height > max) {
        max = height;
        maxIdx = idx;
      }
    }

    int sum = 0;
    int curHeight = board[1];
    for (int i = 1; i < maxIdx; i++) {
      curHeight = Math.max(board[i], curHeight);
      sum += curHeight;
    }

    curHeight = board[1000];
    for (int i = 1000; i > maxIdx ; i--) {
      curHeight = Math.max(board[i], curHeight);
      sum += curHeight;
    }

    System.out.println(sum + max);
  }
}
