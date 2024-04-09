package doh._03._0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 암호만들기_1759 {
    static char[] pass;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Set<Character> sets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        pass = new char[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            pass[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(pass); // 사전순 정렬

        visited = new boolean[c];
        sets = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        // n개 중 r개를 뽑아야한다. (조합)
        backtracking(c, l, 0, 0);
        System.out.println(sb);
    }

    public static void backtracking(int n, int r, int depth, int start) {
        if (depth == r) {
            int required = 0;
            int other = 0;
            Set<String> result = new TreeSet<>();

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    if (sets.contains(pass[i])) {
                        required++;
                    } else { // 다른 문자
                        other++;
                    }
                    result.add(String.valueOf(pass[i]));
                }
            }

            if (required >= 1 && other >= 2) {
                sb.append(String.join("", result));
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            backtracking(n, r, depth + 1, i + 1);
            visited[i] = false;
        }
    }
}
