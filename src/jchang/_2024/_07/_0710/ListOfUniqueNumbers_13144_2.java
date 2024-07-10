package jchang._2024._07._0710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ListOfUniqueNumbers_13144_2 {
  // 길이가 N인 수열, 수열에서 연속한 1개 이상의 수를 뽑았을 때 같은 수가 여러번 등장하지 않는 경우의 수를 구하라
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] input = new int[n];
    long result = 0;
    for (int i = 0; i < n; i++) {
      input[i] = Integer.parseInt(st.nextToken());
      // 전체 경우의 수를 직접 더해서 구한다.
      result += i + 1;
    }

    int left = 0;
    int right = 0;
    int[] numbers = new int[100001];

    while (left <= right && right < n) {

      int count = numbers[input[right]] + 1;

      if (count != 2) {
        numbers[input[right]]++;
        right++;
      } else {
        // 중복되는 수가 있어서 아래 경우의 수만큼 전체 경우의 수에서 제외한다.
        result -= n - right;

        numbers[input[left]]--;
        left++;
      }

    }

    System.out.println(result);
  }
}
