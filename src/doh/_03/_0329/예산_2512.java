package doh._03._0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 예산_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] budget = new int[n]; // 예산 요청
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        int maxReq = 0;

        for (int i = 0; i < n; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            sum += budget[i];
            maxReq = Math.max(maxReq, budget[i]);
        }

        int maxBudget = Integer.parseInt(br.readLine()); // 총 예산

        if (maxBudget >= sum) {
            System.out.println(maxReq);
            System.exit(0);
        }

        int left = 1;
        int right = maxReq;
        int answer = 0;

        while (left < right) {
            int mid = (left + right) / 2; // 상한액
            sum = 0;

            for (int i = 0; i < n; i++) {
                if (budget[i] <= mid) {
                    sum += budget[i];
                } else {
                    sum += mid;
                }
            }

            if (sum <= maxBudget) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(answer);
    }
}
