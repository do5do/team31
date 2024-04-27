package doh._04._0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ListOfUniqueNumbers_13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] count = new int[100001];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int right = 0;
        long answer = 0;
        for (int i = 0; i < n; i++) {
            while (right < n && count[nums[right]] == 0) {
                count[nums[right++]]++;
            }

            answer += right - i;
            count[nums[i]]--;
        }

        System.out.println(answer);
    }
}

// set을 사용하면 메모리 초과
