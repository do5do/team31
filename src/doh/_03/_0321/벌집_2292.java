package doh._03._0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 벌집_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int step = 1;
        int num = 1;

        while (n > num) {
            num += 6 * step;
            step++;
        }

        System.out.println(step);
    }
}

// 1 -> 2~7 -> 8~19 -> 20~37 -> 38~61 ... (6의 배수로 늘어남)
//   +6    +12      +18     +24 ...