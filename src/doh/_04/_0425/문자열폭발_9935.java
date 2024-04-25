package doh._04._0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열폭발_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        int window = bomb.length();
        String s = str.substring(0, window);
        if (bomb.equals(s)) {
            str = str.substring(window);
        }

        int start = 0;

        while (start <= str.length() - window) {
            if (!str.contains(bomb)) {
                break;
            }

            int end = start + window;
            s = str.substring(start, end);

            if (bomb.equals(s)) {
                str = str.substring(0, start) + str.substring(end);
                start = 0;
            } else {
                start++;
            }
        }

        if (str.equals(bomb) || str.isEmpty()) {
            System.out.println("FRULA");
        } else {
            System.out.println(str);
        }
    }
}

// 메모리 초과