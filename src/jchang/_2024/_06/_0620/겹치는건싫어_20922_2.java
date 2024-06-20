package jchang._2024._06._0620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 겹치는건싫어_20922_2 {
  // 같은 원소가 K개 이하로 들어 있는 최장 연속 부분 수열의 길이
  // 부분 수열 --> 투포인터
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] input = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }

    int result = 0;
    int[] count = new int[100001];
    int left = 0;
    int right = 0;
    while (left <= right && right < n) {
      if (count[input[right]] + 1 > k) {
        count[input[left]]--;
        left++;
      } else {
        result = Math.max(right - left + 1, result);
        count[input[right]]++;
        right++;
      }

    }

    System.out.println(result);
  }
}
