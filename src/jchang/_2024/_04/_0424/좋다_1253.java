package jchang._2024._04._0424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_1253 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] board = new int[n];
    board[0] = Integer.parseInt(st.nextToken());
    for (int i = 1; i < n; i++) {
      board[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(board);

    int count = 0;
    for (int i = 0; i < board.length; i++) {
      int left = 0;
      int right = board.length - 1;
      while (left < right) {
        if (left == i) {
          left++;
          continue;
        }
        if (right == i) {
          right--;
          continue;
        }

        int sum = board[left] + board[right];
        if (sum == board[i]) {
          count++;
          break;
        } else if (sum < board[i]) {
          left++;
        } else if (sum > board[i]) {
          right--;
        }
      }
    }

    System.out.println(count);
  }
// 67%
//  public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int n = Integer.parseInt(br.readLine());
//    StringTokenizer st = new StringTokenizer(br.readLine());
//
//    int[] board = new int[n];
//    Set<Integer> set = new HashSet<>();
//    board[0] = Integer.parseInt(st.nextToken());
//    for (int i = 1; i < n; i++) {
//      int cur = Integer.parseInt(st.nextToken());
//      board[i] = cur;
//      for (int j = 0; j < i; j++) {
//        set.add(board[j] + cur);
//      }
//    }
//
//    int count = 0;
//    for (int num : board) {
//      if (set.contains(num)) {
//        count++;
//      }
//    }
//
//    System.out.println(count);
//  }
}
