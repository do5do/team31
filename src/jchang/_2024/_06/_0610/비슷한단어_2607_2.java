package jchang._2024._06._0610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비슷한단어_2607_2 {
  // 같은 구성
  // 1. 두 개의 단어가 같은 종류의 문자로 구성
  // 2. 같은 문자는 같은 개수만큼 존재
  // 비슷한 단어
  // 두 단어가 같은 구성인 경우
  // 한 단어에서 한 문자를 더하거나, 빼거나, 하나의 문자를 다른 문자로 바꾸어 같은 구성을 가지는 경우
  // 비슷한 단어 여부를 확인
  // 두 단어의 같은 문자 개수를 확인하여 경우의 수에 따라 처리
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String original = br.readLine();
    int[] originalAlphabet = new int[26];
    for (int i = 0; i < original.length(); i++) {
      originalAlphabet[original.charAt(i) - 'A']++;
    }

    int result = 0;
    for (int i = 0; i < n - 1; i++) {
      String relative = br.readLine();
      // 최초 문자열과 비교할 문자열의 같은 문자를 카운트한다.(중복문자 제외)
      int sameCount = 0;
      int[] originalCopy = originalAlphabet.clone();
      for (int j = 0; j < relative.length(); j++) {
        if (originalCopy[relative.charAt(j) - 'A'] > 0) {
          sameCount++;
          // 중복 카운트를 방지하기 위해 기존 문자열에서 카운트한 문자는 하나씩 줄여준다.
          // (ex. 기존 문자열 GOD, 비교할 문자열 GOOD 인 경우 비교할 문자열의 O가 2개이고, 기존 문자열에
          // O는 1개이기 때문에 O에 한정한 같은 문자 개수는 기존 문자열 기준에서 카운트하여 1개만 카운트한다.)
          originalCopy[relative.charAt(j) - 'A']--;
        }
      }

      // 같은 구성인 단어의 경우(기존 문자열 길이와 비교할 문자열 길이가 같고 같은 글자수가 비교할 문자열 길이와 같은 경우)
      // 한글자만 바뀐 경우(기존 문자열 길이와 비교할 문자열 길이가 같고 같은 글자수가 비교할 문자열 길이보다 한글자 작은 경우)
      if (original.length() == relative.length() && (relative.length() == sameCount ||
          relative.length() - 1 == sameCount)) {
        result++;
      }
      // 한 문자를 더하는 경우(기존 문자열 길이가 비교할 문자열보다 한글자 더 많고 같은 글자수가 비교할 문자열의 길이와 같은 경우)
      else if(original.length() == relative.length() + 1 && relative.length() == sameCount) {
        result++;
      }
      // 한 문자를 제거하는 경우(기존 문자열 길이가 비교할 문자열보다 한글자 더 작고 같은 글자수가 비교할 문자열의 길이보다 1이 더 작은 경우)
      else if(original.length() == relative.length() - 1 && relative.length() - 1 == sameCount) {
        result++;
      }
    }

    System.out.println(result);
  }
}
