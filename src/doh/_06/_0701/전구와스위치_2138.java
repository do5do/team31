package doh._06._0701;

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

        int[] push = Arrays.copyOf(arr, arr.length);
        toggle(0, push); // 첫번째 스위치 누름

        int answer = -1;
        int cnt = 0;
        int pushCnt = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] != target[i - 1]) {
                toggle(i, arr);
                cnt++;
            }

            if (push[i - 1] != target[i - 1]) {
                toggle(i, push);
                pushCnt++;
            }
        }

        if (check(arr, target)) {
            answer = cnt;
        } else if (check(push, target)) {
            answer = pushCnt;
        }

        System.out.println(answer);
    }

    public static boolean check(int[] arr, int[] target) {
        return Arrays.equals(arr, target);
    }

    public static void toggle(int i, int[] arr) {
        // 1 -> 0, 0 -> 1
        for (int j = i - 1; j <= i + 1; j++) {
            if (j >= 0 && j < arr.length) {
                arr[j] = 1 - arr[j];
            }
        }
    }
}

// ?... 안누른 걸 먼저 해야 맞는다..