package jchang._2024._03._0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11399 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] wait = new int[N];
    for (int i = 0; i < N; i++) {
      wait[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(wait);
    int preSum = 0;
    int totalSum = 0;
    for (int i = 0; i < N; i++) {
      int curSum = preSum + wait[i];
      totalSum += curSum;
      preSum = curSum;
    }

    System.out.println(totalSum);
  }
}
