package doh._07._0704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 인구이동_16234 {
    static int[][] matrix;
    static boolean[][] visited;
    static int sum;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int l, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        // 인구이동이 없을 때 까지 확인
        while (true) {
            visited = new boolean[n][n];
            boolean isMoved = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        List<int[]> moved = new ArrayList<>();
                        dfs(i, j, moved);

                        if (!moved.isEmpty()) {
                            isMoved = true;
                            sum += matrix[i][j];
                            moved.add(new int[] {i, j});

                            int avg = sum / moved.size();
                            for (int[] move : moved) {
                                matrix[move[0]][move[1]] = avg;
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

    public static void dfs(int x, int y, List<int[]> moved) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix.length) {
                int diff = Math.abs(matrix[x][y] - matrix[nx][ny]);

                if (!visited[nx][ny] && diff >= l && diff <= r) {
                    sum += matrix[nx][ny];
                    moved.add(new int[] {nx, ny});
                    dfs(nx, ny, moved);
                }
            }
        }
    }
}
