package jchang._2024._06._0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 볼모으기_17615_2 {
  // 볼을 옮겨서 같은 색 볼끼리 인접하게 놓이도록
  // 바로 옆에 다른 색깔의 볼이 있으면 그 볼을 모두 뛰어 넘어 옮길 수 있다
  // 옮길 수 있는 볼의 색깔은 한가지
  // 최소 이동횟수를 구하라
  // 경우의 수는 왼쪽에서 오른쪽으로 공을 옮기는 경우와 오른쪽에서 왼쪽으로 공을 옮기는 경우가 있을 수 있고,
  // 각 붉은 공을 옮기거나 파란 공을 옮길 수 있기 때문에 총 4가지의 경우가 있다.
  // RBBBRBRRR 의 예제로 생각해보자.
  // 문자열 : R B B B R B R R R
  // 인덱스 : 0 1 2 3 4 5 6 7 8
  // 왼쪽에서 오른쪽으로 빨간공을 옮기는 경우를 생각해보면,
  // 4번 공을 옮기고, 1번 공을 옮기면 된다.
  // 구현 관점에서 보면 마지막 인덱스부터 0번 인덱스로 하나씩 문자를 보면서 최초로 나온 파란공(5번 인덱스) 이후의
  // 붉은 공을 전부 옮겨야 하므로 최초로 나온 파란공(5번 인덱스)보다 작은 인덱스의 붉은 공을 카운트 해주면 된다.
  // 위 과정을 경우의 수에 맞게 반복하면 된다.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String balls = br.readLine();

    int answer = Integer.MAX_VALUE;
    for (int i = 0; i < 2; i++) {
      char count;
      char start;
      if (i == 0) {
        count = 'R';
        start = 'B';
      } else {
        count = 'B';
        start = 'R';
      }

      boolean countStart = false;
      int result = 0;
      // 공을 왼쪽에서 오른쪽으로 옮기는 경우
      for (int j = n - 1; j >= 0; j--) {
        if (balls.charAt(j) == start && !countStart) {
          countStart = true;
          continue;
        }

        if (countStart) {
          if (balls.charAt(j) == count) {
            result++;
          }
        }
      }

      answer = Math.min(result, answer);

      countStart = false;
      result = 0;
      // 공을 오른쪽에서 왼쪽으로 옮기는 경우
      for (int j = 0; j < n; j++) {
        if (balls.charAt(j) == start && !countStart) {
          countStart = true;
          continue;
        }

        if (countStart) {
          if (balls.charAt(j) == count) {
            result++;
          }
        }
      }
      answer = Math.min(result, answer);
    }

    System.out.println(answer);
  }
}
