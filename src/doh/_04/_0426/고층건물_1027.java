package doh._04._0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 고층건물_1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            double cur = 0; // 기울기 : 높이 차이 / 거리

            // 왼쪽
            for (int j = i - 1; j >= 0; j--) {
                double next = (double) (nums[i] - nums[j]) / (i - j);
                if (j == i - 1 || cur > next) { // 바로 옆 건물이거나 전 기울기보다 기울기가 감소해야 j 건물을 볼 수 있는 것
                    cur = next;
                    cnt++;
                }
            }

            // 오른쪽
            for (int j = i + 1; j < n; j++) {
                double next = (double) (nums[i] - nums[j]) / (i - j);
                if (j == i + 1 || cur < next) { // 기울기가 증가해야함
                    cur = next;
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
