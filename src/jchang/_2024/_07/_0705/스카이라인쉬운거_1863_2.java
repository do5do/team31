package jchang._2024._07._0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스카이라인쉬운거_1863_2 {
  // 스카이라인만을 보고 건물이 최소 몇 채 있는지 알아내자.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();
    int count = 0;
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      while (!stack.isEmpty() && y < stack.peek()) {
        count++;
        stack.pop();
      }

      if (!stack.isEmpty() && stack.peek() == y) {
        continue;
      }

      stack.push(y);
    }

    while (!stack.isEmpty() && 0 < stack.peek()) {
      count++;
      stack.pop();
    }

    System.out.println(count);

  }
}
