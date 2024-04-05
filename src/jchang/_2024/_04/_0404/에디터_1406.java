package jchang._2024._04._0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 에디터_1406 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String first = br.readLine();
    int m = Integer.parseInt(br.readLine());

    Stack<Character> stack1 = new Stack<>();
    Stack<Character> stack2 = new Stack<>();
    for (int i = 0; i < first.length(); i++) {
      stack1.push(first.charAt(i));
    }

    for (int i = 0; i < m; i++) {
      String command = br.readLine();
      if (command.equals("L")) {
        if (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      } else if (command.equals("D")) {
        if (!stack2.isEmpty()) {
          stack1.push(stack2.pop());
        }
      } else if (command.equals("B")) {
        if (!stack1.isEmpty()) {
          stack1.pop();
        }
      } else if (command.startsWith("P")) {

        String input = command.split(" ")[1];
        stack1.push(input.charAt(0));
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }

    char[] array = new char[stack1.size()];
    for (int i = 0; i < array.length; i++) {
      array[array.length - 1 - i] = stack1.pop();
    }

    System.out.println(array);
  }
  // 시간초과
//  public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    String first = br.readLine();
//    int m = Integer.parseInt(br.readLine());
//
//    StringBuilder sb = new StringBuilder();
//    sb.append(first);
//    int idx = first.length();
//    for (int i = 0; i < m; i++) {
//      String command = br.readLine();
//      if (command.equals("L")) {
//
//        idx = Math.max(0, idx-1);
//
//      } else if (command.equals("D")) {
//
//        idx = Math.min(sb.length(), idx + 1);
//
//      } else if (command.equals("B")) {
//
//        String left = sb.substring(0, Math.max(0, idx - 1));
//        String right = sb.substring(idx);
//        sb = new StringBuilder().append(left).append(right);
//        idx = Math.max(0, idx - 1);
//
//      } else if (command.startsWith("P")) {
//
//        String input = command.split(" ")[1];
//        String left = sb.substring(0, idx);
//        String right = sb.substring(idx);
//
//        sb = new StringBuilder().append(left).append(input).append(right);
//
//        idx = Math.min(sb.length(), idx + 1);
//      }
//    }
//
//    System.out.println(sb);
//  }
}
