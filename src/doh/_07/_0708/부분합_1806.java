package doh._07._0708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        long sum = 0;

        while (left <= right) {
            if (sum < s) {
                if (right == arr.length - 1) {
                    break;
                }
                sum += arr[right++];
            } else {
                answer = Math.min(answer, right - left);
                sum -= arr[left++];
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
