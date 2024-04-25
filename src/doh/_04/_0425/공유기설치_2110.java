package doh._04._0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        // 거리 기준으로 이분탐색
        int left = 1;
        int right = house[n - 1];
        int max = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt = 1;
            int lastInstall = house[0];
            for (int i = 1; i < n; i++) {
                if (house[i] - lastInstall >= mid) {
                    cnt++;
                    lastInstall = house[i];
                }
            }

            if (cnt < c) {
                right = mid - 1;
            } else {
                max = mid;
                left = mid + 1;
            }
        }

        System.out.println(max);
    }
}
