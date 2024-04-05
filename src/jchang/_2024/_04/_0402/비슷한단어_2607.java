package jchang._2024._04._0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비슷한단어_2607 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int result = 0;

    String target = br.readLine();
    int [] targetCount = new int[26];
    for (int i = 0; i < target.length(); i++) {
      targetCount[target.charAt(i) - 'A']++;
    }

    for (int i = 0; i < n - 1; i++) {
      int[] copy = targetCount.clone();
      String str = br.readLine();
      int count = 0;
      for (int j = 0; j < str.length(); j++) {
        if (copy[str.charAt(j) - 'A'] > 0 ){
          count++;
          copy[str.charAt(j) - 'A']--;
        }
      }

      // 기준 문자열과 비교 문자열 길이가 같은 경우
      if (str.length() == target.length()) {
        // 기준 문자열과 같거나 기준 문자열에서 하나 바꿔끼운 경우만 비슷함
        if (target.length() == count || target.length() - 1 == count) {
          result++;
        }
      }

      // 비교 문자열이 짧은 경우(제거)
      if (str.length() == target.length() - 1) {
        if (str.length() == count) {
          result++;
        }
      }

      // 비교 문자열이 큰 경우(추가)
      if (str.length() == target.length() + 1) {
        if (str.length() == count + 1) {
          result++;
        }
      }
    }


    System.out.println(result);
  }
}
