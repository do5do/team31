package doh._0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 일곱난쟁이_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] tall = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            tall[i] = Integer.parseInt(br.readLine());
            sum += tall[i];
        }

        out: for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (tall[i] + tall[j] + 100 == sum) {
                    tall[i] = 0;
                    tall[j] = 0;
                    break out;
                }
            }
        }

        Arrays.sort(tall);

        for (int i = 2; i < 9; i++) {
            System.out.println(tall[i]);
        }
    }
}
