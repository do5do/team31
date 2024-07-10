package doh._07._0710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ListOfUniqueNumbers_13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        int[] count = new int[100001];
        int right = 0;

        for (int i = 0; i < n; i++) {
            while (right < n) {
                int next = arr[right];

                if (count[next] == 0) {
                    count[next]++;
                    right++;
                } else {
                    break;
                }
            }

            answer += right - i;
            count[arr[i]]--; // 다음수와 겹치는 수 빼기
        }

        System.out.println(answer);
    }
}
