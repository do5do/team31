package doh._0321;

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
