package doh._04._0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int[] answer = new int[n];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int cur = top[i];

            while (!stack.isEmpty()) {
                int[] prev = stack.peek();

                if (cur <= prev[1]) {
                    answer[i] = prev[0];
                    stack.push(new int[] {i + 1, cur});
                    break;
                } else {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                stack.push(new int[] {i + 1, cur});
            }
        }

        for (int a : answer) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}
