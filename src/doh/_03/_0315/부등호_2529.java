package doh._03._0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 부등호_2529 {
    static String[] mark;
    static boolean[] visited;
    static int[] num;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        mark = new String[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            mark[i] = st.nextToken();
        }

        visited = new boolean[10];
        num = new int[k + 1];

        backtracking(0, k + 1);

        System.out.println(result.get(result.size() - 1)); // max
        System.out.println(result.get(0)); // min
    }

    public static void backtracking(int depth, int r) {
        if (depth == r) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                sb.append(num[i]);
            }
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                // 부등호 확인
                if (check(i, depth)) {
                    num[depth] = i;
                    backtracking(depth + 1, r);
                }
                visited[i] = false;
            }
        }
    }

    private static boolean check(int curNum, int depth) {
        if (depth == 0) {
            return true;
        }

        String curMark = mark[depth - 1];
        if (curMark.equals(">")) {
            if (num[depth - 1] > curNum) {
                return true;
            }
        } else { // <
            if (num[depth - 1] < curNum) {
                return true;
            }
        }

        return false;
    }
}