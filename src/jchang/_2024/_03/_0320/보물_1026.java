package jchang._2024._03._0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 메모리 초과
public class 보물_1026 {
  static int min = Integer.MAX_VALUE;
  static int N;
  static int[] A;
  static int[] B;
//  static int[] result;
//  static boolean[] visited;
//  static int sum = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    A = new int[N];
    B = new int[N];
//    result = new int[N];
//    visited = new boolean[N];

    for (int i = 0; i < 2; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        if (i == 0) {
          A[j] = Integer.parseInt(st.nextToken());
        } else {
          B[j] = Integer.parseInt(st.nextToken());
        }
      }
    }

    // dfs(0);
    Arrays.sort(A);
    Arrays.sort(B);
    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += A[i] * B[N - 1 - i];
    }
    System.out.println(sum);
  }

//  private static void dfs(int idx) {
//    if (idx == N) {
//      min = Math.min(Arrays.stream(result).sum(), min);
//      return;
//    }
//
//    for (int i = 0; i < N; i++) {
//      if (!visited[i]) {
//        result[idx] = A[i] * B[idx];
//        visited[i] = true;
//        dfs(idx + 1);
//        visited[i] = false;
//      }
//    }
//  }
}
