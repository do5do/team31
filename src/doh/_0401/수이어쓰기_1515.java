package doh._0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수이어쓰기_1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums = br.readLine();

        int idx = 0;
        int base = 1;

        out: while (idx < nums.length()) {
            String baseStr = String.valueOf(base);
            for (int j = 0; j < baseStr.length(); j++) {
                if (baseStr.charAt(j) == nums.charAt(idx)) {
                    idx++;
                }

                if (idx == nums.length()) {
                    break out;
                }
            }
            base++;
        }

        System.out.println(base);
    }
}
