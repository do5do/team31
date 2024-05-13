package jchang._2024._05._0513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑보기_22866 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] heights = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
    }

    int[] count = new int[n + 1];
    int[] near = new int[n + 1];

    Stack<Integer> stack = new Stack<>();

    for (int i = 1; i <= n; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        count[i] = stack.size();
        near[i] = stack.peek();
      }

      stack.push(i);
    }

    stack = new Stack<>();
    for (int i = n; i >= 1; i--) {
      while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
        stack.pop();
      }
      if (!stack.isEmpty()) {
        count[i] += stack.size();
        if (near[i] != 0 && stack.peek() - i < i - near[i]) {
          near[i] = stack.peek();
        } else if (near[i] == 0) {
          near[i] = stack.peek();
        }
      }
      stack.push(i);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      if (count[i] > 0) {
        sb.append(count[i]);
        sb.append(" ").append(near[i]);
      } else {
        sb.append(0);
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
