package jchang._2024._06._0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수이어쓰기_1515_2 {
  // 1 ~ N
  // 다솜이가 몇개 숫자 지웠는데 N이 기억 안남
  // 남은 수를 이어 붙인 수가 주어질 때, N의 최소값
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String number = br.readLine();

    int pointer = 0;
    String base = null;
    loop :
    for (int i = 1; i < 30000; i++) {
      base = String.valueOf(i);
      for (int j = 0; j < base.length(); j++) {
        if (number.charAt(pointer) == base.charAt(j)) {
          pointer++;
        }
        if (pointer == number.length()) {
          break loop;
        }
      }
    }

    System.out.println(base);
  }
}
