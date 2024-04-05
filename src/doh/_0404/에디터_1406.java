package doh._0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 에디터_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String base = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Stack<String> left = new Stack<>();
        Deque<String> right = new LinkedList<>();

        for (int i = 0; i < base.length(); i++) {
            left.push(String.valueOf(base.charAt(i)));
        }

        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            if (cmd.startsWith("P")) {
                left.push(cmd.split(" ")[1]);
            } else if (cmd.startsWith("L")) {
                if (!left.isEmpty()) {
                    right.offerFirst(left.pop());
                }
            } else if (cmd.startsWith("D")) {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            } else {
                if (!left.isEmpty()) {
                    left.pop();
                }
            }
        }

        System.out.println(String.join("", left) + String.join("", right));
    }
}
