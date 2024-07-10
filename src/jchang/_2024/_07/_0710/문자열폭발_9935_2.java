package jchang._2024._07._0710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열폭발_9935_2 {
  // 폭발 문자열이 폭발하면 그 문자는 문자열에서 사라지고, 남은 문자열은 합쳐지게 된다.
  // 폭발은 폭발 문자열이 문자열에 없을 때까지 계속 된다.
  // 남은 문자열을 구하라. 남는 문자가 없으면 FLURA를 출력한다.
  // 폭발 문자열은 같은 문자를 두 개 이상 포함하지 않는다.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String bomb = br.readLine();

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      stack.push(ch);
      if (ch == bomb.charAt(bomb.length() - 1)) {
        Stack<Character> temp = new Stack<>();
        if (stack.size() < bomb.length()) {
          continue;
        }

        for (int j = bomb.length() - 1; j >= 0; j--) {
          char pop = stack.pop();
          temp.push(pop);
          if (pop != bomb.charAt(j)) {
            while (!temp.isEmpty()) {
              stack.push(temp.pop());
            }
            break;
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
      System.out.println(sb.reverse());
    }

  }
}
