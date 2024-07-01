package jchang._2024._07._0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액_2467_2 {
  // 각 용액에 특성을 나타내는 하나의 정수가 주어짐
  // 산성욕액은 양수, 알칼리성 용액은 음수
  // 혼합하여 특성값이 0에 가까운 용액을 만든다.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] input = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }

    int left = 0;
    int right = n - 1;
    long min = Long.MAX_VALUE;
    int[] result = new int[2];

    while (left < right) {
      long mix = input[left] + input[right];

      if (Math.abs(mix) < min) {
        min = Math.abs(mix);
        result[0] = input[left];
        result[1] = input[right];
      }

      if (mix < 0) {
        left++;
      } else if (mix > 0) {
        right--;
      } else {
        break;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int num : result) {
      sb.append(num).append(" ");
    }
    System.out.println(sb);
  }
}
