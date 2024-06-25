package doh._06._0625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B2_12919 {
    static int answer = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        dfs(t, s);
        System.out.println(answer);
    }

    public static void dfs(String t, String s) {
        if (t.length() == s.length()) {
            if (t.equals(s)) {
                answer = 1;
            }
            return;
        }

        if (t.charAt(t.length() - 1) == 'A') {
            dfs(t.substring(0, t.length() - 1), s);
        }

        if (t.charAt(0) == 'B') {
            sb.append(t.substring(1));
            String reversed = sb.reverse().toString();
            sb.setLength(0);
            dfs(reversed, s);
        }
    }
}
