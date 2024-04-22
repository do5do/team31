package doh._04._0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스카이라인쉬운거_1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(x, y);
        }

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int height = nodes[i].y;

            while (!stack.isEmpty() && stack.peek() > height) {
                cnt++;
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek() == height) {
                continue;
            }

            stack.push(height);
        }

        while (!stack.isEmpty()) {
            if (stack.peek() != 0) {
                cnt++;
            }
            stack.pop();
        }

        System.out.println(cnt);
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
