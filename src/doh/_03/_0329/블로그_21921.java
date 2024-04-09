package doh._03._0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블로그_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] days = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            days[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int cnt = 1;
        int sum = 0;

        for (int i = 0; i < x; i++) {
            sum += days[i];
        }
        max = sum;

        for (int i = 0; i < n; i++) {
            sum -= days[i];
            if (i + x < n) {
                sum += days[i + x];
            } else {
                break;
            }

            if (sum == max) {
                cnt++;
                continue;
            }

            if (sum > max) {
                max = sum;
                cnt = 1;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            System.exit(0);
        }

        System.out.println(max);
        System.out.println(cnt);
    }
}