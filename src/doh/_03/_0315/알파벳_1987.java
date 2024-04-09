package doh._03._0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_1987 {
    static int r, c;
    static int[][] matrix;
    static boolean[] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        matrix = new int[r][c];
        visited = new boolean[26];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                matrix[i][j] = line.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 1);
        System.out.println(max);
    }

    public static void dfs(int x, int y, int cnt) {
        visited[matrix[x][y]] = true;
        max = Math.max(cnt, max);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                if (!visited[matrix[nx][ny]]) {
                    dfs(nx, ny, cnt + 1);
                    visited[matrix[nx][ny]] = false;
                }
            }
        }
    }
}
