package tjoon._202404._0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액_2467 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] liquid = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquid[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = n - 1;
        long min = Integer.MAX_VALUE;
        long sum = 0;
        long[] answer = new long[2];

        while (left < right) {

            sum = liquid[left] + liquid[right];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer[0] = liquid[left];
                answer[1] = liquid[right];
            }

            if (sum >= 0) {
                right--;
            } else {
                left++;
            }

        }

        System.out.println(answer[0] + " " + answer[1]);

    }
}
