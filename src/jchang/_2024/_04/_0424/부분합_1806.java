package jchang._2024._04._0424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합_1806 {
  // 시간초과..
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] board = new int[n];
    for (int i = 0; i < n; i++) {
      board[i] = Integer.parseInt(st.nextToken());
    }

    int left = 0;
    int right = 0;
    int result = Integer.MAX_VALUE;
    int sum = board[0];
    while (left < board.length && right < board.length ) {

      if (sum >= s) {
        result = Math.min(result, right - left + 1);
        if (left < right) {
          sum -= board[left];
          left++;
        } else {
          result = 1;
          break;
        }
      } else {
        if (right < board.length - 1) {
          right++;
          sum += board[right];
        } else {
          sum -= board[left];
          left++;
        }
      }
    }

    if (result == Integer.MAX_VALUE) {
      result = 0;
    }

    System.out.println(result);
  }
}
