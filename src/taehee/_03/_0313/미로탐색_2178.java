package taehee._03._0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_2178 {

  static int N, M;
  static Node[][] maze;
  static boolean[][] visited;
  static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    N = Integer.parseInt(tokenizer.nextToken());
    M = Integer.parseInt(tokenizer.nextToken());
    maze = new Node[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        maze[i][j] = new Node(i, j, line.charAt(j));
      }
    }

    Queue<Node> queue = new LinkedList<>();
    maze[0][0].count = 1;
    queue.add(maze[0][0]);

    int count = 0;

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      int x = node.x;
      int y = node.y;

      if (x == N - 1 && y == M - 1) {
        count = node.count;
        break;
      }

      for (int[] dir : dirs) {
        int nextX = node.x + dir[0];
        int nextY = node.y + dir[1];

        Node next = getNext(nextX, nextY);
        if (next != null) {
          queue.add(next);
          visited[nextX][nextX] = true;
          maze[nextX][nextY].count = node.count + 1;
        }
      }
    }

    System.out.println(count);
  }

  static Node getNext(int x, int y) {
    if (x >= 0 && x < N && y >= 0 && y < N && !visited[x][y] && maze[x][y].value == '1') {
      return maze[x][y];
    }

    return null;
  }

  static class Node {

    char value;
    int count;
    int x;
    int y;

    Node(int x, int y, char value) {
      this.x = x;
      this.y = y;
      this.value = value;
    }
  }
}
