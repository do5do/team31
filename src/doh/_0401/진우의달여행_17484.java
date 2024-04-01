package doh._0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진우의달여행_17484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dy = {-1, 0, 1};
        int[][][] dp = new int[n][m][3];

        // 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    dp[0][j][0] = matrix[0][j];
                    dp[0][j][1] = matrix[0][j];
                    dp[0][j][2] = matrix[0][j];
                } else { // 나머지는 최대값으로 초기화
                    dp[i][j][0] = 1000000;
                    dp[i][j][1] = 1000000;
                    dp[i][j][2] = 1000000;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    int nx = i - 1;
                    int ny = j + dy[k];

                    if (ny < 0 || ny >= m) {
                        continue;
                    }

                    // 0 -> 1,2 / 1 -> 0,2 / 2 -> 0,1
                    dp[i][j][k] = Math.min(dp[i][j][k], dp[nx][ny][(k + 1) % 3] + matrix[i][j]);
                    dp[i][j][k] = Math.min(dp[i][j][k], dp[nx][ny][(k + 2) % 3] + matrix[i][j]);
                }
            }
        }

        // 마지막줄에서 최소값 출력
        int min = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            for (int k = 0; k < 3; k++) {
                min = Math.min(min, dp[n - 1][j][k]);
            }
        }
        System.out.println(min);
    }
}
