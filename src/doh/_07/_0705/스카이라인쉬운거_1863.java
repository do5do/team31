package doh._07._0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스카이라인쉬운거_1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] building = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            building[i] = y;
        }

        int cnt = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()) {
                if (stack.peek() > building[i]) {
                    cnt++;
                    stack.pop();
                } else {
                    break;
                }
            }

            if (!stack.isEmpty() && stack.peek() == building[i]) {
                continue;
            }

            stack.push(building[i]);
        }

        while (!stack.isEmpty()) {
            if (stack.peek() != 0) {
                cnt++;
            }
            stack.pop();
        }

        System.out.println(cnt);
    }
}
