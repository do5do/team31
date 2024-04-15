package doh._04._0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬된 상태로 들어옴
//        Arrays.sort(nums);

        int left = 0;
        int right = n - 1;
        long min = Long.MAX_VALUE;
        int[] answer = new int[2];

        while (left < right) {
            long num = nums[right] + nums[left];
            // 아래 조건은 94퍼에서 틀림
//            if (nums[left] < 0) {
//                num = nums[right] + nums[left];
//            } else {
//                num = nums[right] - nums[left];
//            }

            if (Math.abs(num) < min) {
                min = Math.abs(num);
                answer[0] = nums[left];
                answer[1] = nums[right];
            }

            if (num > 0) {
                right--;
            } else if (num < 0) {
                left++;
            } else {
                break;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
