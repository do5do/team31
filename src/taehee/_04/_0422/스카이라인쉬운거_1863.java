package taehee._04._0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스카이라인쉬운거_1863 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();
    int count = 0;

    for (int i = 0; i < n; i++) {
      StringTokenizer tokenizer = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(tokenizer.nextToken());
      int y = Integer.parseInt(tokenizer.nextToken());

      if (stack.isEmpty()) {
        stack.push(y);
      } else {
        int peek = stack.peek();

        if (peek < y) {
          stack.push(y);
        } else if (peek > y) {
          while (!stack.isEmpty() && stack.peek() != y) {
            stack.pop();
            count++;

            if (stack.isEmpty()) {
              count++;
            }
          }
        }
      }
    }

    System.out.println(count);
  }
}
