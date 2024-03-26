package doh._0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 비밀번호발음하기_4659 {
    static Set<Character> vowel = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u')); // 모음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line; // password
        StringBuilder sb = new StringBuilder();

        while (true) {
            line = br.readLine();
            if ("end".equals(line)) {
                break;
            }

            if (check(line)) {
                sb.append("<").append(line).append("> is acceptable.").append("\n");
            } else {
                sb.append("<").append(line).append("> is not acceptable.").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean check(String password) {
        int vowelCnt = 0; // 모음
        int vowelSeq = 0;
        int consonantSeq = 0;

        for (int i = 0; i < password.length(); i++) {
            if (vowel.contains(password.charAt(i))) {
                vowelCnt++;
                consonantSeq = 0;
                vowelSeq++;
            } else {
                vowelSeq = 0;
                consonantSeq++;
            }

            if (i + 1 < password.length()) {
                if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) != 'e' && password.charAt(i) != 'o') {
                    return false; // same
                }
            }

            if (vowelSeq >= 3 || consonantSeq >= 3) {
                return false;
            }
        }

        if (vowelCnt < 1) {
            return false;
        }

        return true;
    }
}
