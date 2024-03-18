package doh._0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로봇프로젝트_3649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }
            int x = Integer.parseInt(line) * 10_000_000; // 구멍의 너비 cm -> nm
            int n = Integer.parseInt(br.readLine());

            int[] piece = new int[n];
            for (int i = 0; i < n; i++) {
                piece[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(piece);

            int[] answer = new int[2];
            boolean flag = false;

            // 투포인터! (이중 for문은 시간초과)
            int start = 0;
            int end = n - 1;

            while (start < end) {
                int val = piece[start] + piece[end];

                if (val > x) {
                    end--;
                } else if (val == x) {
                    flag = true;
                    answer[0] = piece[start];
                    answer[1] = piece[end];
                    break;
                } else {
                    start++;
                }
            }

            if (flag) {
                System.out.println("yes" + " " + answer[0] + " " + answer[1]);
            } else {
                System.out.println("danger");
            }
        }
    }
}