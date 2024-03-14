package taehee._0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동_7562 {

  static int testCase;
  static int[][] matrix;
  static int[][] move;
  static int startX, startY;
  static int endX, endY;
  static boolean[][] visited;

  static int[][] dirs = new int[][]
      {
          {-2, -1}, // 10시
          {-1, -2}, // 11시
          {1, -2}, // 1시
          {2, -1}, // 2시
          {2, 1}, // 4시
          {1, 2,}, // 5시
          {-1, 2}, // 7시
          {-2, 1} // 8시
      };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    testCase = Integer.parseInt(br.readLine());

    for (int i = 0; i < testCase; i++) {
      // 1
      int l = Integer.parseInt(br.readLine());
      matrix = new int[l][l];
      move = new int[l][l];
      visited = new boolean[l][l];

      // 2
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      startX = Integer.parseInt(tokenizer.nextToken());
      startY = Integer.parseInt(tokenizer.nextToken());

      tokenizer = new StringTokenizer(br.readLine());
      endX = Integer.parseInt(tokenizer.nextToken());
      endY = Integer.parseInt(tokenizer.nextToken());

      Queue<Integer[]> queue = new LinkedList<>();
      queue.add(new Integer[]{startX, startY});
      move[startX][startY] = 0;
      visited[startX][startY] = true;

      while (!queue.isEmpty()) {
        Integer[] node = queue.poll();
        int x = node[0];
        int y = node[1];

        if (x == endX && y == endY) {
          System.out.println(move[x][y]);
          break;
        }

        for (int[] dir : dirs) {
          int nextX = x + dir[0];
          int nextY = y + dir[1];

          if (movable(nextX, nextY)) {
            queue.add(new Integer[]{nextX, nextY});
            visited[nextX][nextY] = true;
            move[nextX][nextY] = move[x][y] + 1;
          }
        }
      }
    }
  }

  static boolean movable(int x, int y) {
    return (x >= 0 && x < matrix.length && y >= 0 && y < matrix.length
        && !visited[x][y]);
  }
}
