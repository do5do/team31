package jchang._2024._07._0709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_1987_2 {
  // 세로 R, 가로 C칸, 보드의 각 칸에 대문자 알파벳 적혀 있음
  // 좌측 상단(1행 1열) 말이 있다.
  // 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과 달라야 함
  // 말이 최대한 몇 칸 지날 수 있는지 구하라. 말이 지나는 칸은 좌측 상단의 칸도 포함
  static int r, c, result;
  static char[][] board;
  static boolean[] alphabetVisited;
  static int[] dx = new int[]{0, 0, 1, -1};
  static int[] dy = new int[]{-1, 1, 0, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    board = new char[r][c];
    for (int i = 0; i < r; i++) {
      String line = br.readLine();
      for (int j = 0; j < c; j++) {
        board[i][j] = line.charAt(j);
      }
    }

    alphabetVisited = new boolean[26];
    alphabetVisited[board[0][0] - 'A'] = true;
    result = 0;

    dfs(0, 0, 1);
    System.out.println(result);
  }

  private static void dfs(int x, int y, int count) {
    result = Math.max(count, result);

    for (int i = 0; i < dx.length; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
        continue;
      }

      if (!alphabetVisited[board[nx][ny] - 'A']) {
        alphabetVisited[board[nx][ny] - 'A'] = true;
        dfs(nx, ny, count + 1);
        alphabetVisited[board[nx][ny] - 'A'] = false;
      }

    }
  }
}
