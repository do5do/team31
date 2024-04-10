package doh._03._0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 좋은수열_2661 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        backtracking(0, n, "");
    }

    public static void backtracking(int depth, int r, String result) {
        if (depth == r) {
            System.out.println(result);
            System.exit(0); // 처음 찾은게 최소값
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (check(depth, result + i)) {
                backtracking(depth + 1, r, result + i);
            }
        }
    }

    public static boolean check(int depth, String num) {
        if (depth == 0) {
            return true;
        }

        for (int i = 1; i <= num.length() / 2; i++) {
            String cur = num.substring(num.length() - i);
            String prev = num.substring(num.length() - i - i, num.length() - i);

            if (cur.equals(prev)) {
                return false;
            }
        }

        return true;
    }
}