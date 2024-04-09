package doh._0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼더하기4_15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t > 0) {
            t--;
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[10001][4];

            // n을 만드는 수에서 m으로 끝나는 수식의 개수
            dp[1][1] = 1;
            dp[2][1] = 1; // 1+1
            dp[2][2] = 1; // 2
            dp[3][1] = 1; // 1+1+1
            dp[3][2] = 1; // 1+2
            dp[3][3] = 1; // 3

            for (int i = 4; i <= n; i++) {
                dp[i][1] = dp[i - 1][1];
                dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
                dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
            }

            sb.append(dp[n][1] + dp[n][2] + dp[n][3]).append("\n");
        }

        System.out.println(sb);
    }
}