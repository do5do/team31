package jchang._2024._07._0708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_1253_2 {
  // N개의 수 중에서 어떤 수가 다른 수 두개의 합으로 나타낼 수 있으면 좋다
  // 좋은 수의 개수?
  // 수의 위치가 다르면 값이 같아도 다른 수이다.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] input = new int[n];
    for (int i = 0; i < n; i++) {
      int a = Integer.parseInt(st.nextToken());
      input[i] = a;
    }
    Arrays.sort(input);

    int count = 0;
    for (int i = 0; i < n; i++) {
      int left = 0;
      int right = n - 1;

      while (left < right) {
        if (i == left) {
          left++;
          continue;
        } else if (i == right) {
          right--;
          continue;
        }
        int sum = input[left] + input[right];

        if (input[i] == sum) {
          count++;
          break;
        } else if (input[i] > sum) {
          left++;
        } else if (input[i] < sum) {
          right--;
        }
      }
    }

    System.out.println(count);
  }
}
