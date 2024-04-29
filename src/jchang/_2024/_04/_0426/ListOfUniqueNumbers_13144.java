package jchang._2024._04._0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ListOfUniqueNumbers_13144 {
// 메모리 초과
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] board = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      board[i] = Integer.parseInt(st.nextToken());
    }

    long result = 0;
    int[] visited = new int[100001];
    int left = 0;
    int right = 0;
    visited[board[left]]++;

    while (left < n) {
      if (right + 1 < n && visited[board[right + 1]] == 0) {
        right++;
        visited[board[right]]++;
        continue;
      }
      result += right - left + 1;
      visited[board[left]]--;
      left++;
    }
    System.out.println(result);
  }

}
// 결과값이 long이어야만 했었다..