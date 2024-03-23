package doh._0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어공부_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] count = new int[26];

        for (int i = 0; i < word.length(); i++) {
            String a = word.substring(i, i + 1).toUpperCase();
            count[a.charAt(0) - 'A']++;
        }

        int max = 0;
        char answer = 0;

        for (int i = 0; i < count.length; i++) {
            if (max != 0 && count[i] == max) {
                answer = '?';
            } else if (count[i] > max) {
                max = count[i];
                answer = (char) (i + 'A');
            }
        }

        System.out.println(answer);
    }
}
