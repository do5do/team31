package jchang._2024._04._0424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_1987 {
  static boolean[] alphabet = new boolean[26];
  static int[] dx = new int[]{-1, 1, 0, 0};
  static int[] dy = new int[]{0, 0, -1, 1};
  static int r;
  static int c;
  static char[][] board;
  static int result = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    board = new char[r][c];
    for (int i = 0; i < r; i++) {
      String str = br.readLine();
      for (int j = 0; j < c; j++) {
        board[i][j] = str.charAt(j);
      }
    }

    alphabet[board[0][0] - 'A'] = true;
    dfs(0, 0, 1);
    System.out.println(result);
  }

  private static void dfs(int x, int y, int sum) {

    for (int i = 0; i < dx.length; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
        continue;
      }

      if (!alphabet[board[nx][ny] - 'A']) {
        alphabet[board[nx][ny] - 'A'] = true;
        dfs(nx, ny, sum + 1);
        alphabet[board[nx][ny] - 'A'] = false;
      }
    }

    result = Math.max(sum, result);
  }
}
