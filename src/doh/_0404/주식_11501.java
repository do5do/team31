package doh._0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주식_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t > 0) {
            t--;
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] price = new int[n];

            for (int i = 0; i < n; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            int max = price[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                if (price[i] >= max) {
                    max = price[i];
                } else {
                    answer += max - price[i];
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}