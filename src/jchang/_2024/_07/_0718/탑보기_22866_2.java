package jchang._2024._07._0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑보기_22866_2 {
  // 건물 총 N개, 현재 건물의 높이 L
  // 보이는 건물 개수랑 가장 가까이 보이는 건물 번호(작은수)
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] heights = new int[n + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
    }

    int[][] result = new int[n + 1][2];
    Stack<Building> stack = new Stack<>();
    for (int i = 1; i <= n; i++) {
      while (!stack.isEmpty() && stack.peek().height <= heights[i]) {
        stack.pop();
      }

      result[i][0] = stack.size();
      if (!stack.isEmpty()) {
        result[i][1] = stack.peek().index;
      }

      stack.push(new Building(heights[i], i));
    }

    stack.clear();
    for (int i = n; i >= 1; i--) {
      while (!stack.isEmpty() && stack.peek().height <= heights[i]) {
        stack.pop();
      }

      result[i][0] += stack.size();
      if (!stack.isEmpty()) {
        if (result[i][1] != 0) {
          int leftGap = Math.abs(i - result[i][1]);
          int rightGap = Math.abs(i - stack.peek().index);

          if (rightGap < leftGap) {
            result[i][1] = stack.peek().index;
          }
        } else {
          result[i][1] = stack.peek().index;
        }
      }

      stack.push(new Building(heights[i], i));
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1 ; i <= n; i++) {
      if (result[i][0] == 0) {
        sb.append(0);
      } else {
        sb.append(result[i][0]).append(" ").append(result[i][1]);
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static class Building {
    int height, index;
    public Building(int height, int index) {
      this.height = height;
      this.index = index;
    }
  }
}
