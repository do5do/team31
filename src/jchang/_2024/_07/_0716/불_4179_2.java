package jchang._2024._07._0716;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불_4179_2 {
  // 지훈이가 불에 타기전에 탈출할 수 있는지 여부, 얼마나 빨리 탈출할수 있는지를 결정
  // 불은 네방향으로 확산
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    char[][] board = new char[r][c];

    int[][] dpFire = new int[r][c];
    int[][] dpHuman = new int[r][c];
    for (int i = 0; i < r; i++) {
      Arrays.fill(dpFire[i], -1);
      Arrays.fill(dpHuman[i], -1);
    }

    int[] jiHoon = new int[2];
    Queue<int[]> fires = new LinkedList<>();
    for (int i = 0; i < r; i++) {
      String input = br.readLine();
      for (int j = 0; j < c; j++) {
        board[i][j] = input.charAt(j);
        if (board[i][j] == 'J') {
          jiHoon[0] = i;
          jiHoon[1] = j;
          dpHuman[i][j] = 0;
        }

        if (board[i][j] == 'F') {
          fires.add(new int[]{i, j});
          dpFire[i][j] = 0;
        }
      }
    }

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    while (!fires.isEmpty()) {
      int[] curFire = fires.poll();

      for (int i = 0; i < dx.length; i++) {
        int nx = curFire[0] + dx[i];
        int ny = curFire[1] + dy[i];

        if (nx < 0 || ny < 0 || nx >= r || ny >= c || board[nx][ny] == '#') {
          continue;
        }

        if (board[nx][ny] != 'F' && dpFire[nx][ny] == -1) {
          dpFire[nx][ny] = dpFire[curFire[0]][curFire[1]] + 1;
          fires.add(new int[]{nx, ny});
        }
      }
    }

    PriorityQueue<int[]> human = new PriorityQueue<>(
        (x, y) -> dpHuman[x[0]][x[1]] - dpHuman[y[0]][y[1]]);
    human.add(jiHoon);

    while (!human.isEmpty()) {
      int[] cur = human.poll();

      for (int i = 0; i < dx.length; i++) {
        int nx = cur[0] + dx[i];
        int ny = cur[1] + dy[i];

        if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
          System.out.println(dpHuman[cur[0]][cur[1]] + 1);
          return;
        }

        if (board[nx][ny] == '.' && dpHuman[nx][ny] == -1
            && dpHuman[cur[0]][cur[1]] + 1 < (dpFire[nx][ny] == -1 ? Integer.MAX_VALUE : dpFire[nx][ny])) {
          dpHuman[nx][ny] = dpHuman[cur[0]][cur[1]] + 1;
          human.add(new int[]{nx, ny});
        }
      }
    }

    System.out.println("IMPOSSIBLE");
  }
}
