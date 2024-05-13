package tjoon._202404._0429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 줄세우기_2631 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] line = new int[n];
        for (int i = 0; i < n; i++) {
            line[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];
        dp[0] = 1;

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (line[j] < line[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(n - max);

    }
}
