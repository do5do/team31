package jchang._2024._07._0704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 인구이동_16234_3 {
  // 국경선 공유 L명 이상 R명 이하면 국경선 오픈
  // 연합의 인구수 / 연합을 이루고 있는 칸의 개수
  // 인구이동 며칠동안 일어나나
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());

    int[][] board = new int[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    boolean isChange = true;
    int stage = 0;
    while (isChange) {
      isChange = false;
      boolean[][] visited = new boolean[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (!visited[i][j]) {
            Queue<Node> q = new LinkedList<>();
            Set<Node> set = new HashSet<>();

            q.add(new Node(i, j));
            visited[i][j] = true;
            int sum = 0;
            while (!q.isEmpty()) {
              Node cur = q.poll();
              sum += board[cur.x][cur.y];
              set.add(cur);

              for (int k = 0; k < dx.length; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                  continue;
                }

                if (!visited[nx][ny]) {
                  int gap = Math.abs(board[nx][ny] - board[cur.x][cur.y]);
                  if (gap >= l && gap <= r) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                  }
                }
              }
            }

            if (set.size() > 1) {
              isChange = true;
              int avg = sum / set.size();
              for (Node node : set) {
                board[node.x][node.y] = avg;
              }
            }
          }
        }
      }

      if (isChange) {
        stage++;
      }
    }

    System.out.println(stage);

  }

  public static class Node{
    int x, y;
    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
