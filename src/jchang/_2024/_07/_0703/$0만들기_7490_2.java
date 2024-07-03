package jchang._2024._07._0703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class $0만들기_7490_2 {
  // 1 ~ N
  // '+', '-', ' ' 을 넣어서 0을 만드는 모든 수식을 찾자
  static StringBuilder sb = new StringBuilder();
  static Set<String> set;
  static int n;
  static char[] operators = new char[]{'+', '-', ' '};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      n = Integer.parseInt(br.readLine());
      set = new TreeSet<>();
      StringBuilder result = new StringBuilder();

      dfs(1, result);

      for (String s : set) {
        sb.append(s).append("\n");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  private static void dfs(int num, StringBuilder s) throws IOException {
    // 새로운 StringBuilder에 기존 StringBuilder를 더하고 숫자를 추가한다.
    StringBuilder newStr = new StringBuilder().append(s).append(num);
    // 탈출조건 - StringBuilder가 연산자를 다 넣은 문자열의 길이가 되면 탈출한다.
    if (newStr.length() == (n + (n - 1))) {
      // 단, 수식 문자열을 실제로 계산하여 0이 되면 만들어둔 set에 기록한다.
      if (calculate(newStr)) {
        set.add(newStr.toString());
      }
      return;
    }

    // 연산자 3가지를 순회하며 넣어본다.
    for (int j = 0; j < 3; j++) {
      newStr.append(operators[j]);
      dfs(num + 1, newStr);
      newStr.deleteCharAt(newStr.length() - 1);
    }
  }

  private static boolean calculate(StringBuilder s) {
    String target = s.toString();
    StringBuilder number = new StringBuilder();

    Stack<Integer> numbers = new Stack<>();
    Stack<Character> operator = new Stack<>();
    // 들어온 수식 문자열을 처음부터 순회하면서
    for (int i = 0; i < target.length(); i++) {
      // 해당 문자열의 문자가 숫자이면 number에 append한다.
      if (target.charAt(i) - '0' <10 && target.charAt(i) - '0' >= 0) {
        number.append(target.charAt(i));
      }

      // 연산자가 나오면 지금까지 만든 숫자 문자열 number는 int로 변환하여 numbers 스택에 넣고
      // 연산자는 operator 스택에 넣는다.
      if (target.charAt(i) == '+' || target.charAt(i) == '-') {
        operator.push(target.charAt(i));
        numbers.push(Integer.parseInt(number.toString()));
        number = new StringBuilder();
      }
    }
    // 마지막에 만들어진 숫자도 numbers 스택에 넣는다.
    numbers.push(Integer.parseInt(number.toString()));

    int result = 0;
    // 스택에서 하나씩 빼면서 계산을 한다.
    while (!operator.isEmpty()) {
      int num = numbers.pop();
      char op = operator.pop();

      if (op == '-') {
        num *= -1;
      }

      result += num;
    }

    result += numbers.pop();

    // 결과값이 0인지 여부를 boolean으로 반환한다.
    return result == 0;
  }
}
