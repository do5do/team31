package doh._07._0715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 줄세우기_2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // LIS(최장 증가 부분 수열) 구하기
        int[] dp = new int[n];
        int lis = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 초기값

            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            lis = Math.max(lis, dp[i]);
        }

        // LIS를 제외한 나머지만 옮겨주면 된다.
        System.out.println(n - lis);
    }
}
