package jchang._2024._04._0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불_4179 {

  static char[][] maze;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int[][] dpFire = new int[r][c];
    int[][] dpJihoon = new int[r][c];

    maze = new char[r][c];
    Queue<Fire> fire = new LinkedList<>();
    Queue<Node> nodes = new LinkedList<>();
    for (int i = 0; i < r; i++) {
      String str = br.readLine();
      for (int j = 0; j < c; j++) {
        maze[i][j] = str.charAt(j);
        dpFire[i][j] = -1;
        dpJihoon[i][j] = -1;
        if (maze[i][j] == 'F') {
          dpFire[i][j] = 0;
          fire.add(new Fire(i, j));
        } else if (maze[i][j] == 'J') {
          dpJihoon[i][j] = 0;
          nodes.add(new Node(i, j));
        }
      }
    }

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    while (!fire.isEmpty()) {
      Fire cur = fire.poll();

      for (int i = 0; i < dx.length; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (nx < 0 || ny < 0 || nx >= r || ny >= c || maze[nx][ny] == '#') {
          continue;
        }

        if (dpFire[nx][ny] == -1) {
          dpFire[nx][ny] = dpFire[cur.x][cur.y] + 1;
          fire.offer(new Fire(nx, ny));
        }
      }
    }

    while (!nodes.isEmpty()) {
      Node cur = nodes.poll();

      for (int i = 0; i < dx.length; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];

        if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
          System.out.println(dpJihoon[cur.x][cur.y] + 1);
          return;
        }
        if (maze[nx][ny] == '#' || maze[nx][ny] == 'F') {
          continue;
        }
        if (dpJihoon[cur.x][cur.y] + 1 < (dpFire[nx][ny] == -1 ? Integer.MAX_VALUE : dpFire[nx][ny])
            && dpJihoon[nx][ny] == -1) {
          dpJihoon[nx][ny] = dpJihoon[cur.x][cur.y] + 1;
          nodes.add(new Node(nx, ny));
        }

      }
    }


    System.out.println("IMPOSSIBLE");
  }

  static class Fire {

    int x, y;

    public Fire(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static class Node {

    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
//4 6
//######
//#..J.#
//#....#
//F....#

//3 4
//##.#
//FJ.#
//##F#