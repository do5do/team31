package doh._04._0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회전초밥_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] dish = new int[n];
        int[] count = new int[d + 1];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            dish[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            count[dish[i]]++;
            if (count[dish[i]] == 1) {
                cnt++;
            }
        }

        int answer = cnt;
        int left = 0;
        int right = k;

        // n - 1까지 해야 안틀린다..
        while (left < n) {
            if (count[c] == 0) { // 쿠폰 확인
                answer = Math.max(answer, cnt + 1);
            } else {
                answer = Math.max(answer, cnt);
            }

            count[dish[left]]--;
            if (count[dish[left]] == 0) {
                cnt--;
            }

            int tmp = right;
            if (right >= n) {
                tmp = right - n;
            }

            count[dish[tmp]]++;
            if (count[dish[tmp]] == 1) { // 처음 먹는 경우
                cnt++;
            }

            left++;
            right++;
        }

        System.out.println(answer);
    }
}