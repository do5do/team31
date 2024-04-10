package doh._04._0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진우의달여행_17484_2 {
    static int[] dy = {-1, 0, 1};
    static int n;
    static int m;
    static int[][] matrix;
    static int min = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 0; j < m; j++) {
            dfs(0, j,-1, matrix[0][j]);
        }

        System.out.println(min);
    }

    static void dfs(int x, int y,  int direction, int value) {
        if (x == n - 1) {
            min = Math.min(value, min);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (i != direction) {
                int nx = x + 1;
                int ny = y + dy[i];

                if (nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                dfs(nx, ny, i, value + matrix[nx][ny]);
            }
        }
    }
}
