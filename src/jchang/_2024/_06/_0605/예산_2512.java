package jchang._2024._06._0605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 예산_2512 {
  // 예산 총액 이하에서 가능한 최대의 예산을 배정 --> 이분탐색
  // 모든 요청이 배정될 수 있는 경우 그대로 배정
  // 그렇지 않은 경우 특정한 정수 상한액을 계산하여 그 이상의 예산요청은 상한액 배정, 나머지는 그대로 배정
  // 가장 높게 배정된 금액을 구하라
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] request = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      request[i] = Integer.parseInt(st.nextToken());
    }

    int m = Integer.parseInt(br.readLine());

    // 모든 요청이 배정될 수 있는 경우는 배열에서 max값 출력후 종료
    int total = Arrays.stream(request).sum();
    if (total <= m) {
      System.out.println(Arrays.stream(request).max().getAsInt());
      return;
    }

    // 모든 요청이 배정될 수 없는 경우는 이분탐색으로 최대의 상한액을 찾아서 출력
    int min = 1;
    int max = m;
    int result = 0;
    while (min <= max) {
      int mid = (max - min)/2 + min;

      int sum = 0;
      for (int num : request) {
        if (num > mid) {
          sum += mid;
        } else {
          sum += num;
        }
      }
      boolean isPass = sum <= m;

      if (isPass) {
        min = mid + 1;
        result = mid;
      } else {
        max = mid - 1;
      }
    }

    System.out.println(result);
  }
}
