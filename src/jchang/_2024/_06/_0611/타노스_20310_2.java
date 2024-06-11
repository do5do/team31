package jchang._2024._06._0611;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타노스_20310_2 {
  // 0과 1로 이루어진 문자열 S
  // S가 포함하는 0의 개수와 1의 개수는 모두 짝수
  // 절반의 0과 절반의 1을 제거하여 새로운 문자열을 만듬, 사전순으로 가장 빠른 것
  // 문제 포인트는 기존 문자열에서 0과 1을 제거해 나가는 것
  // 사전순으로 가장 빠른 것을 찾으려면 왼쪽에 0이 많아야 하기 때문에 왼쪽에서부터 1을 지워나가고, 오른쪽에서부터 0을 지워나간다.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] str = br.readLine().toCharArray();

    int oneCount = 0;
    int zeroCount = 0;
    // 0과 1의 개수를 센다.
    for (int i = 0; i < str.length; i++) {
      if (str[i] == '1') {
        oneCount++;
      } else {
        zeroCount++;
      }
    }

    // 왼쪽에서부터 1을 1의 총 개수 반까지 제거해나간다.
    // 오른쪽에서부터 0을 0의 총 개수 반까지 제거해나간다.
    int oneHalf = oneCount / 2;
    int zeroHalf = zeroCount / 2;
    for (int i = 0; i < str.length; i++) {
      if (str[i] == '1' && oneHalf > 0) {
        str[i] = '-';
        oneHalf--;
      }

      if (str[str.length - 1 - i] == '0' && zeroHalf > 0) {
        str[str.length - 1 - i] = '-';
        zeroHalf--;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length; i++) {
      if (str[i] != '-') {
        sb.append(str[i]);
      }
    }

    System.out.println(sb);
  }
}
