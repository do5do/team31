package doh._06._0627;

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

        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                int[] prev = stack.peek();
                if (cur > prev[0]) { // 수신 못함
                    stack.pop();
                } else {
                    stack.push(new int[] {cur, i + 1});
                    sb.append(prev[1]).append(" ");
                   break;
                }
            }

            if (stack.isEmpty()) {
                stack.push(new int[] {cur, i + 1});
                sb.append("0 ");
            }
        }

        System.out.println(sb);
    }
}
