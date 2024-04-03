package doh._0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 타노스_20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] origin = str.clone();
        Arrays.sort(str);

        int zero = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '0') {
                zero++;
            } else {
                break;
            }
        }

        int one = (str.length - zero) / 2;
        zero /= 2;

        for (int i = origin.length - 1; i >= 0; i--) {
            if (origin[i] == '0') {
                origin[i] = 'x';
                zero--;
            }
            if (zero == 0) {
                break;
            }
        }

        for (int i = 0; i < origin.length; i++) {
            if (origin[i] == '1') {
                origin[i] = 'x';
                one--;
            }
            if (one == 0) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < origin.length; i++) {
            if (origin[i] != 'x') {
                sb.append(origin[i]);
            }
        }

        System.out.println(sb);
    }
}
