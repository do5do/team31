package jchang._2024._04._0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class 숫자고르기_2668 {
  static int[] board;
  static Set<Integer> set;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    board = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      board[i] = Integer.parseInt(br.readLine());
    }

    set = new TreeSet<>();
    visited = new boolean[n + 1];
    for (int i = 1; i < board.length; i++) {
      visited[i] = true;
      dfs(i, i);
      visited[i] = false;
    }

    StringBuilder sb = new StringBuilder();
    sb.append(set.size()).append("\n");
    for (Integer num : set) {
      sb.append(num).append("\n");
    }
    System.out.println(sb);
  }

  private static void dfs(int start, int target) {
    if (board[start] == target) {
      set.add(target);
      return;
    }

    if (!visited[board[start]]) {
      visited[board[start]] = true;
      dfs(board[start], target);
      visited[board[start]] = false;
    }
  }
}
