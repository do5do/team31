package jchang._2024._06._0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑_2493_2 {
  // N개의 높이가 서로 다른 탑을 수평 직석의 왼쪽부터 오른쪽 방향으로 세움
  // 꼭대기 레이저 송신기(레이더 방향 왼쪽 수평방향)
  // 각 탑에서 발사한 수신처

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] input = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int top = Integer.parseInt(st.nextToken());
      input[i] = top;
    }

    int[] result = new int[n];
    Stack<Building> stack = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && input[i] >= stack.peek().height) {
        Building cur = stack.pop();
        result[cur.idx] = i + 1;
      }
      stack.push(new Building(input[i], i));
    }

    while (!stack.isEmpty()) {
      Building cur = stack.pop();
      result[cur.idx] = 0;
    }

    StringBuilder sb = new StringBuilder();
    for (int num : result) {
      sb.append(num).append(" ");
    }
    System.out.println(sb);
  }

  public static class Building {
    int height, idx;
    public Building(int height, int idx) {
      this.height = height;
      this.idx = idx;
    }
  }

}
