package jchang._2024._06._0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 인구이동_16234_2 {
  // N X N의 땅이 있다.
  // 각 땅에 나라가 하나씩 존재하며, 인구가 있다.
  // 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면 국경선 연다.
  // 국경선을 열어 연합이 된 나라의 인구수는 (연합의 인구수) / (연합을 이루고 있는 나라의 개수)
  // 소수점은 버림
  // 연합 해체 후 국경선 닫는다
  // 인구이동이 몇일동안 이루어지나?
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

    boolean isChange = true;
    int stage = 0;
    int[] dx = new int[]{0, 1, -1, 0};
    int[] dy = new int[]{1, 0, 0, -1};
    // 인구이동이 없을 때까지 반복문을 실행한다.
    while (isChange) {

      isChange = false;
      // 방문한 나라를 다시 방문하지 않도록 visited배열을 초기화한다.
      boolean[][] visited = new boolean[n][n];

      // 모든 나라를 방문하면서 방문한 나라와 국경을 접하고 있는 나라가 연합이 가능한지 확인한다.
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          // 방문하지 않은 나라만 연합가능여부 확인한다.
          if (!visited[i][j]) {
            // 방문 처리
            visited[i][j] = true;

            // bfs로 연합 가능한 나라를 확인하는데, 연합 가능한 나라를 따로 모아서 관리하기 위해 set을 하나 추가로 만든다.
            // 나라는 int 배열로 처리한다.(행, 열, 인구수)
            Queue<int[]> q = new LinkedList<>();
            Set<int[]> set = new HashSet<>();
            int[] country = new int[]{i, j, board[i][j]};
            q.add(country);
            set.add(country);
            // 연합 가능한 나라의 인구수의 평균을 구하기 위해 방문할 때마다 인구수를 합해준다.
            int sum = 0;

            while (!q.isEmpty()) {
              int[] cur = q.poll();
              sum += cur[2];

              for (int k = 0; k < dx.length; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];

                if (nx >= n || ny >= n || nx < 0 || ny < 0) {
                  continue;
                }

                int gap = Math.abs(cur[2] - board[nx][ny]);
                if (gap >= l && gap <= r && !visited[nx][ny]) {
                  // 연합가능한 나라는 방문한 것으로 처리한다.
                  visited[nx][ny] = true;
                  int[] next = new int[]{nx, ny, board[nx][ny]};
                  q.add(next);
                  set.add(next);
                }
              }
            }

            // 연합 가능한 나라가 2개 이상인 경우 각 연합 나라의 인구수를 평균으로 바꿔준다.
            if (set.size() > 1) {
              isChange = true;

              int avg = sum / set.size();
              for (int[] ele : set) {
                board[ele[0]][ele[1]] = avg;
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
}
