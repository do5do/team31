package jchang._2024._04._0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑_2493 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] tops = new int[n + 1];
    Stack<int[]> stack = new Stack<>();
    for (int i = 1; i < tops.length; i++) {
      tops[i] = Integer.parseInt(st.nextToken());
    }

    int[] result = new int[n + 1];

    int out = tops[tops.length - 1];
    int outIdx = tops.length - 1;
    stack.push(new int[]{out, outIdx});
    for (int i = tops.length - 2; i >= 0; i--) {
      if (tops[i] > tops[i + 1]) {
        result[i + 1] = i;
      } else {
        stack.push(new int[]{tops[i + 1], i + 1});
      }

      if (!stack.isEmpty() && tops[i] > stack.peek()[0]) {
        while (!stack.isEmpty() && tops[i] > stack.peek()[0]) {
          result[stack.pop()[1]] = i;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < result.length; i++) {
      sb.append(result[i]).append(" ");
    }

    System.out.println(sb);
  }
}
