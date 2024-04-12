package doh._04._0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 인구이동_26234 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] matrix;
    static boolean[][] visited;
    static int n, l, r;
    static List<int[]> nodes = new ArrayList<>();
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken()); // 이상
        r = Integer.parseInt(st.nextToken()); // 이하

        matrix = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        boolean check = false;

        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        dfs(i, j);
                        if (sum > 0) { // 인구 이동
                            check = true;

                            // 시작 값 추가
                            nodes.add(new int[] {i, j});
                            int avg = (sum + matrix[i][j]) / nodes.size();
                            for (int[] idx : nodes) {
                                matrix[idx[0]][idx[1]] = avg;
                            }
                            nodes.clear();
                            sum = 0;
                        }
                    }
                }
            }

            if (check) { // 인구 이동했으면 방문배열 초기화 후 재탐색
                answer++;
                visited = new boolean[n][n];
                check = false;
            } else {
                break;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visited[nx][ny]) {
                    int val = Math.abs(matrix[x][y] - matrix[nx][ny]);
                    if (val >= l && val <= r) {
                        sum += matrix[nx][ny];
                        nodes.add(new int[] {nx, ny});
                        dfs(nx, ny);
                    }
                }
            }
        }
    }
}
