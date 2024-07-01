package doh._06._0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n - 1;
        long min = Long.MAX_VALUE;
        int[] answer = new int[2];

        while (left < right) {
            long val = arr[left] + arr[right];

            if (min > Math.abs(val)) {
                min = Math.abs(val);
                answer[0] = arr[left];
                answer[1] = arr[right];
            }

            if (val > 0) {
                right--;
            } else if (val < 0) {
                left++;
            } else {
                break;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
