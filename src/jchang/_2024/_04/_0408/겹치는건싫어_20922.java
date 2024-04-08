package jchang._2024._04._0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 겹치는건싫어_20922 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    Map<Integer, Integer> counter = new HashMap<>();
    int[] board = new int[n];
    for (int i = 0; i < board.length; i++) {
      int element = Integer.parseInt(st.nextToken());
      board[i] = element;
    }

    int left = 0;
    int right = 0;
    int max = 0;
    while (left < board.length && right < board.length) {
      counter.put(board[right], counter.getOrDefault(board[right], 0) + 1);
      if (counter.get(board[right]) > k) {
        counter.put(board[left], counter.get(board[left]) - 1);
        counter.put(board[right], counter.get(board[right]) - 1);
        left++;
      } else {
        max = Math.max(max, right - left + 1);
        right++;
      }
    }
    for (int i = 0; i < n; i++) {


    }
    // 1 2 3 3 3 (2개 허용)
    System.out.println(max);
  }
}
