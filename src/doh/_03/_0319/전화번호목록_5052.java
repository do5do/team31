package doh._03._0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 전화번호목록_5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] number = new String[n];

            for (int j = 0; j < n; j++) {
                number[j] = br.readLine();
            }

            Arrays.sort(number);

            boolean flag = true;
            for (int j = 0; j < n - 1; j++) {
                String num = number[j];

                if (number[j + 1].startsWith(num)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
