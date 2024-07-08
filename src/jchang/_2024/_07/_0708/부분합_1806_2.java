package jchang._2024._07._0708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합_1806_2 {
  // 10,000 이하의 자연수로 이루어진 길이 N 수열
  // 연속된 수들의 부분합 중에 그 합이 S이상이 되는 것 중 가장 짧은 것의 길이를 구하라
  // 길이와 부분합을 구해야 해서 투포인터와 슬라이딩윈도우를 사용한다.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] input = new int[n];
    for (int i = 0; i < n; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }

    int result = Integer.MAX_VALUE;
    int left = 0;
    int right = 0;
    int sum = input[0];  // 처음의 슬라이딩 윈도우
    while (left <= right) {
      // 합이 S보다 크면 결과값 갱신 및 left 슬라이딩윈도우에서 left에 해당하는 값 빼고 left 오른쪽으로 하나 이동
      if (sum >= s) {
        result = Math.min(result, right - left + 1);
        sum -= input[left];
        left++;
      // 합이 S보다 작고 right이 마지막 인덱스인 경우에는 left 슬라이딩윈도우에서 left에 해당하는 값 빼고 left 오른쪽으로 하나 이동
      } else if (right == n - 1) {
        sum -= input[left];
        left++;
      // 합이 S보다 작고 right이 마지막 인덱스보다 작은 경우에는 right을 하나 이동시키고 슬라이딩윈도우에 값을 추가
      }else if (right < n - 1) {
        right++;
        sum += input[right];
      }
    }

    System.out.println(result == Integer.MAX_VALUE ? 0 : result);
  }
}
