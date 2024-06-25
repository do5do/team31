package jchang._2024._06._0624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열교환_1522_2 {
  // a를 연속으로 만들기 위해 필요한 교환의 횟수
  // 문자열은 원형신
  // 슬라이딩 윈도우 --> 윈도우 사이즈는 b의 총 개수!
  // 윈도우에 a 개수 최소값을 구하면 된다.
  // ex. abababababababa : b 7개
  // 처음 윈도우 인덱스 0 ~ 6 : abababa --> a : 4개
  // 두번째 윈도우 인덱스 1 ~ 7 : bababab --> a : 3개
  // 세번째 윈도우 인덱스 2 ~ 8 : abababa --> a : 4개
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    // 문자열에 b가 몇 개인지 카운트한다.
    int bCount = 0;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == 'b') {
        bCount++;
      }
    }

    // 처음으로 구성하는 윈도우(인덱스 0~ bCount-1)의 a 개수를 카운트한다.
    int aCount = 0;
    for (int i = 0; i < bCount; i++) {
      if (input.charAt(i) == 'a') {
        aCount++;
      }
    }


    int result = aCount;
    // 문자열을 순회하며 슬라이딩 윈도우에 하나 추가하고 하나 제거하여 a개수를 계산한다.
    for (int i = 1; i < input.length(); i++) {
      // 원소 하나 제거
      if (input.charAt(i - 1) == 'a') {
        aCount--;
      }

      // 원소 하나 추가
      int idx = (i + bCount - 1) % input.length();
      if (input.charAt(idx) == 'a') {
        aCount++;
      }

      result = Math.min(result, aCount);
    }

    System.out.println(result);
  }
}
