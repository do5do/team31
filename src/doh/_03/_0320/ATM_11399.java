package doh._03._0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);

        int[] answer = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += time[i];
            answer[i] = sum;
        }

        System.out.println(Arrays.stream(answer).sum());
    }
}
