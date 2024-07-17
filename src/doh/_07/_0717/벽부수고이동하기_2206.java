package doh._07._0717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_2206 {
    static int n, m;
    static int[][] matrix;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 1, 0}); // count, isCrush
        boolean[][][] visited = new boolean[n][m][2];
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int isCrush = cur[3];

            if (cur[0] == n - 1 && cur[1] == m - 1) {
                min = Math.min(min, cur[2]);
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int next = cur[2] + 1;

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (isCrush == 1) { // 벽을 부수고 온 경우
                        if (!visited[nx][ny][1] && matrix[nx][ny] == 0) {
                            visited[nx][ny][1] = true;
                            queue.offer(new int[] {nx, ny, next, 1});
                        }
                    } else { // 벽을 안 부수고 온 경우
                        if (!visited[nx][ny][1] && matrix[nx][ny] == 1) {
                            // 부수고 가는 경우
                            visited[nx][ny][1] = true;
                            queue.offer(new int[] {nx, ny, next, 1});
                        }

                        if (!visited[nx][ny][0] && matrix[nx][ny] == 0) {
                            // 그냥 가는 경우
                            visited[nx][ny][0] = true;
                            queue.offer(new int[] {nx, ny, next, 0});
                        }
                    }
                }
            }
        }
    }
}
