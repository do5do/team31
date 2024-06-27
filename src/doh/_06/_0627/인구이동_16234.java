package doh._06._0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 인구이동_16234 {
    static int[][] matrix;
    static int n, l, r;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 인구이동이 없을 때까지 지속
        int cnt = 0;
        while (true) {
            boolean isMoved = false;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        List<int[]> moves = bfs(i, j);

                        if (!moves.isEmpty()) {
                            isMoved = true;
                            sum += matrix[i][j];
                            moves.add(new int[] {i, j});

                            // 인구 이동 위치 값 변경
                            int value = sum / moves.size();
                            for (int[] m : moves) {
                                matrix[m[0]][m[1]] = value;
                            }
                            sum = 0;
                        }
                    }
                }
            }

            if (!isMoved) {
                break;
            } else {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static List<int[]> bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        List<int[]> moves = new LinkedList<>();

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visited[nx][ny]) {
                        int diff = Math.abs(matrix[cur[0]][cur[1]] - matrix[nx][ny]);
                        if (diff >= l && diff <= r) {
                            moves.add(new int[] {nx, ny});
                            sum += matrix[nx][ny];

                            visited[nx][ny] = true;
                            queue.offer(new int[] {nx, ny});
                        }
                    }
                }
            }
        }

        return moves;
    }
}
