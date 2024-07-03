package jchang._2024._07._0703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빌런호석_22251_2 {
  // 1~N층까지 엘리베이터
  // 디스플레이 K 자리의 수가 보임. 0으로 시작가능
  // 빌런은 최소 1개 최대 P개를 반전시킬 계획을 가지고 있다.
  // 1 이상 N이하가 되도록 바꾸려고 한다.
  // X층에 멈춰있을 때, 호석이가 반전시킬 LED를 고를 수 있는 경우의 수를 계산해보자
  static int k;
  static String[] numbers;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    numbers = new String[10];
    numbers[0] = "1011111";
    numbers[1] = "0000101";
    numbers[2] = "1110110";
    numbers[3] = "1110101";
    numbers[4] = "0101101";
    numbers[5] = "1111001";
    numbers[6] = "1111011";
    numbers[7] = "1000101";
    numbers[8] = "1111111";
    numbers[9] = "1111101";

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    int p = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    int[] target = display(x);
    int result = 0;
    for (int i = 1; i <= n; i++) {
      int count = 0;
      int[] candidate = display(i);

      for (int j = 0; j < candidate.length; j++) {
        for (int l = 0; l < 7; l++) {
          if (numbers[target[j]].charAt(l) != numbers[candidate[j]].charAt(l)) {
            count++;
          }
        }
      }

      if (count > 0 && count <= p) {
        result++;
      }
    }

    System.out.println(result);
  }

  private static int[] display(int target) {
    int[] display = new int[k];

    for (int i = k - 1; i >= 0; i--) {
      display[i] = target % 10;
      target /= 10;
    }

    return display;
  }

}
