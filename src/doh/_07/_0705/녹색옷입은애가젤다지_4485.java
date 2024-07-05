package doh._07._0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지_4485 {
    static int n;
    static int[][] matrix;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while (true) {
            idx++;
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = bfs();
            sb.append(String.format("Problem %d: %d\n", idx, answer));
        }

        System.out.println(sb);
    }

    public static int bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        pq.offer(new int[] {0, 0, matrix[0][0]});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[0] == n - 1 && cur[1] == n - 1) {
                return cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        pq.offer(new int[] {nx, ny, cur[2] + matrix[nx][ny]});
                    }
                }
            }
        }

        return -1;
    }
}
