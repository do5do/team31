package jchang._0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_1987 {

  static char[][] board;
  static int R;
  static int C;
  static int result;
  static int[] dx;
  static int[] dy;
  static boolean[] checked = new boolean[100]; // 알파벳 개수
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    board = new char[R+1][C+1];
    visited = new boolean[R+1][C+1];

    for (int i = 0; i < R; i++) {
      String str = br.readLine();
      for (int j = 0; j < C; j++) {
        board[i + 1][j + 1] = str.charAt(j);
      }
    }

    result = 0;


    dx = new int[]{-1, 1, 0, 0};
    dy = new int[]{0, 0, -1, 1};
    checked[board[1][1]] = true;
    visited[1][1] = true;
    dfs(1, 1, 1);

    System.out.println(result);

  }

  private static void dfs(int x, int y, int idx) {

    result = Math.max(result, idx);

    for (int i = 0; i < dx.length; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx < 1 || ny < 1 || nx > R || ny > C ) {
        continue;
      }

      if (!visited[nx][ny] && !checked[board[nx][ny]]){
        checked[board[nx][ny]] = true;
        visited[nx][ny] = true;
        dfs(nx, ny, idx + 1);
        checked[board[nx][ny]] = false;
        visited[nx][ny] = false;
      }

    }

  }

}
