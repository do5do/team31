package doh._07._0704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 전구와스위치_2138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String str2 = br.readLine();

        int[] arr = new int[n];
        int[] target = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = str.charAt(i) - '0';
            target[i] = str2.charAt(i) - '0';
        }

        int[] pushed = Arrays.copyOf(arr, n); // 누른 경우
        change(0, pushed);

        int cnt = 0;
        int pushedCnt = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] != target[i - 1]) {
                change(i, arr);
                cnt++;
            }

            if (pushed[i - 1] != target[i - 1]) {
                change(i, pushed);
                pushedCnt++;
            }
        }

        if (check(arr, target)) {
            System.out.println(cnt);
            return;
        }

        if (check(pushed, target)) {
            System.out.println(pushedCnt);
            return;
        }

        System.out.println(-1);
    }

    public static boolean check(int[] arr, int[] target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target[i]) {
                return false;
            }
        }
        return true;
    }

    public static void change(int idx, int[] arr) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 0 && i < arr.length) {
                arr[i] = 1 - arr[i];
            }
        }
    }
}
