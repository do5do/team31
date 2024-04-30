package tjoon._202404._0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발_9935 {

    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String sb1 = br.readLine());
//        sb2 = new StringBuilder(br.readLine());
//
//        while (str1.indexOf(sb2) >= 0) {
//
//            int start = sb1.toString().indexOf(sb2.toString());
//
//            sb1.delete(start, start + sb2.toString().length());
        //    str1 = str1.replaceAll(str2, "");
//        }
//
//        if (sb1.toString().isEmpty()) {
//            System.out.println("FRULA");
//        } else {
//            System.out.println(sb1);
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str1.length(); i++) {
            stack.push(str1.charAt(i)); // 한문자씩 삽입

            if (stack.size() < str2.length()) {
                continue;
            }

            boolean flag = true;
            for (int j = 0; j < str2.length(); j++) {
                if (stack.get(stack.size() - str2.length() + j) != str2.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                for (int j = 0; j < str2.length(); j++) {
                    stack.pop();
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }

        if (sb.toString().isEmpty()) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }

    }
}
