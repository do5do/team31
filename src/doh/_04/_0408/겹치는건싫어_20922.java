package doh._04._0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 겹치는건싫어_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, nums[i]);
        }

        int left = 0;
        int right = 0;
        int[] count = new int[max + 1];
        int answer = 0;

        while (right < n) {
            count[nums[right]]++;

            if (count[nums[right]] <= k) {
                answer = Math.max(answer, right - left + 1);
                right++;
            } else {
                count[nums[left]]--;
                count[nums[right]]--;
                left++;
            }
        }

        System.out.println(answer);
    }
}
