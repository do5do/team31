package doh._04._0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열교환_1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int windowSize = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'a') {
                windowSize++;
            }
        }

        int bCnt = 0;
        for (int i = 0; i < windowSize; i++) {
            if (line.charAt(i) == 'b') {
                bCnt++;
            }
        }

        int min = bCnt;
        for (int i = 0; i < line.length(); i++) {
            char start = line.charAt(i);
            char end = line.charAt((i + windowSize) % line.length());

            if (start == 'b') {
                bCnt--;
            }

            if (end == 'b') {
                bCnt++;
            }

            min = Math.min(min, bCnt);
        }

        System.out.println(min);
    }
}
