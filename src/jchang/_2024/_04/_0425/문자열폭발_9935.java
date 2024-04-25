package jchang._2024._04._0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발_9935 {
  // 메모리 초과
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String init = br.readLine();
    String bomb = br.readLine();

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < init.length(); i++) {
      stack.push(init.charAt(i));

      if (stack.size() >= bomb.length() && stack.peek() == bomb.charAt(bomb.length() - 1)) {
        boolean flag = true;
        for (int j = 0; j < bomb.length(); j++) {
          if (stack.get(stack.size() - 1 - j) != bomb.charAt(bomb.length() - 1 - j)) {
            flag = false;
            break;
          }
        }
        if (flag) {
          for (int j = 0; j < bomb.length(); j++) {
            stack.pop();
          }
        }

      }
    }

    StringBuilder sb = new StringBuilder();
    if (stack.isEmpty()) {
      System.out.println("FRULA");
    } else {
      while (!stack.isEmpty()) {
        sb.append(stack.pop());
      }
    }
    System.out.println(sb.reverse());
  }

}
