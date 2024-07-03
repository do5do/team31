package doh._07._0703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _0만들기_7490 {
    static int n;
    static char[] op = new char[] {'+', '-', ' '};
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            t--;
            n = Integer.parseInt(br.readLine());

            dfs(0, new char[n - 1]);

            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (String s : list) {
                sb.append(s).append("\n");
            }

            System.out.println(sb);
        }
    }

    public static void dfs(int depth, char[] result) {
        if (depth == n - 1) {
            StringBuilder origin = new StringBuilder();
            for (int i = 0; i < n - 1; i++) {
                origin.append(i + 1).append(result[i]);
            }
            origin.append(n);
            String str = origin.toString();

            if (isZero(str)) {
                list.add(str);
            }
            return;
        }

        for (int i = 0; i < op.length; i++) {
            result[depth] = op[i];
            dfs(depth + 1, result);
        }
    }

    public static boolean isZero(String origin) {
        String numStr = origin.replaceAll(" ", "");

        StringTokenizer st = new StringTokenizer(numStr, "+|-", true);
        int sum = Integer.parseInt(st.nextToken());

        while (st.hasMoreElements()) {
            String s = st.nextToken();
            if (s.equals("+")) {
                sum += Integer.parseInt(st.nextToken());
            } else if (s.equals("-")) {
                sum -= Integer.parseInt(st.nextToken());
            }
        }

        return sum == 0;
    }
}
