package doh._04._0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한줄로서기_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (cnt == num && arr[j] == 0) {
                    arr[j] = i + 1;
                    break;
                }

                if (arr[j] == 0) {
                    cnt++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }
}
