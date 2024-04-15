package doh._04._0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 전구와스위치_2138 {
    static int n;
    static int[] a, a2, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String str2 = br.readLine();
        a = new int[n]; // 0번 스위치 안누른 경우
        for (int i = 0; i < n; i++) {
            a[i] = str.charAt(i) - '0';
        }
        a2 = Arrays.copyOf(a, n); // 0번 스위치 누른 경우
        change(0, a2);

        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = str2.charAt(i) - '0';
        }

        int cnt = 0;
        int cnt2 = 1;
        int answer = -1;

        for (int i = 1; i < n; i++) {
            if (a[i - 1] != b[i - 1]) {
                change(i, a);
                cnt++;

            }
            if (a2[i - 1] != b[i - 1]) {
                change(i, a2);
                cnt2++;
            }

            boolean check = check(a);
            boolean check2 = check(a2);

            if (check && check2) {
                answer = Math.min(cnt, cnt2);
                break;
            } else if (check) {
                answer = cnt;
                break;
            } else if (check2) {
                answer = cnt2;
                break;
            }
        }

        System.out.println(answer);
    }

    public static boolean check(int[] arr) {
        for (int i = 0; i < n; i++) {
            if (arr[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void change(int i, int[] arr) {
        for (int j = i -1; j <= i + 1; j++) {
            if (j >= 0 && j < n) {
                arr[j] = 1 - arr[j];
            }
        }
    }
}
