package doh._04._0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발_9935_2 {
    static String bomb;
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        bomb = br.readLine();


        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (stack.size() < bomb.length()) {
                continue;
            }

            if (check()) {
                for (int j = 0; j < bomb.length(); j++) {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for (Character s : stack) {
                sb.append(s);
            }
            System.out.println(sb);
        }
    }

    static boolean check() {
        for (int j = 0; j < bomb.length(); j++) {
            if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}