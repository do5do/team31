package jchang._2024._07._0715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 줄세우기_2631_2 {
  // N명의 아이들이 있다. 번호표가 있다.
  // 위치를 옮기는 아이들의 수를 최소한으로 해서 번호 순서대로 줄을 세우자
  // LIS 최장증가부분수열의 길이를 구하는 문제
  // ex. 3 7 5 2 6 1 4
  // 위 예시에서는 최장증가부분수열이 3 5 6 이다. 최장증가부분수열 길이가 3이기 때문에 전체 갯수에서 3개를 뺀 4개가 답이다.
  // DP를 통해 각 인덱스에서의 최장증가부분수열의 길이를 기록한다.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] input = new int[n];
    for (int i = 0; i < n; i++) {
      input[i] = Integer.parseInt(br.readLine());
    }

    int[] dp = new int[n];
    // 0번 인덱스의 최장증가부분수열 길이는 무조건 1이다.(자기 자신)
    dp[0] = 1;
    int lis = 0;
    for (int i = 1; i < n; i++) {
      // 일단 보수적으로 해당 인덱스에 자기 자신 하나만 있는 경우로 dp를 기록한다.
      dp[i] = 1;
      // 해당 인덱스(i)보다 앞에 input 배열을 순회하면서 자신의 값(input[i])보다 작은 숫자(input[j])가 나오는 경우
      // 작은 숫자의 인덱스의 dp 값(dp[j]) + 1과 해당 인덱스의 dp 값(dp[i])과 비교하며 더 큰 값을 dp[i]에 갱신한다.
      for (int j = 0; j < i; j++) {
        if (input[j] < input[i]) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
        }
      }
      // 최장증가부분수열 길이 중 최대값을 갱신한다.
      lis = Math.max(lis, dp[i]);
    }

    System.out.println(n - lis);
  }
}
