package jchang._2024._03._0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난쟁이_2309 {

  static int[] input;
  static int[] result;
  static boolean[] visited;
  static boolean flag = false;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    input = new int[9];
    result = new int[7];
    visited = new boolean[9];
    for (int i = 0; i < input.length; i++) {
      input[i] = Integer.parseInt(br.readLine());
    }

    dfs(0);
  }

  private static void dfs(int idx) {
    if (idx == 7) {
      int sum = Arrays.stream(result).sum();
      if (sum == 100) {
        Arrays.sort(result);
        for (int n : result) {
          System.out.println(n);
        }
        flag = true;
      }
      return;
    }


    for (int i = 0; i < input.length; i++) {
      if (!visited[i]) {
        result[idx] = input[i];
        visited[i] = true;
        dfs(idx + 1);
        visited[i] = false;
      }
      if (flag){
        break;
      }
    }
  }
}
