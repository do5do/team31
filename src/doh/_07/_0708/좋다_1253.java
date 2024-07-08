package doh._07._0708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int target = arr[i];
            int left = 0;
            int right = n - 1;

            while (left < right) {
                long sum = arr[left] + arr[right];

                if (sum == target) {
                    if (i != left && i != right) {
                        cnt++;
                        break;
                    } else if (i == left) {
                        left++;
                    } else {
                        right--;
                    }
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(cnt);
    }
}
