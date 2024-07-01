package jchang._2024._07._0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 전구와스위치_2138_2 {
  // N개의 스위치, N개의 전구
  // 전국는 켜져 있거나 꺼져 있거나이다
  // i번 스위치를 누르면 i -1, i, i + 1 전구 상태가 바뀜
  // 현재 상태에서 만들고자 하는 상태로 스위치를 최소 몇번 눌러야 변경가능한가?
  // 0은 켜져있고, 1은 꺼져있다.
  // 첫 전구의 켜고 끈 경우로 나누어 스위치를 누르도록 진행하는 이유는 첫번째 전구의 최종 상태는 두번째 스위치에 따라 결정되기 때문에,
  // 첫번째 스위치를 누르고 진행하는 것과, 첫번째 스위치를 누르지 않고 진행하는 것은 각각 독립적인 결과를 가져오기 떄문이다.
  static boolean[] origin, to, originSwitchFirst;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    String original = br.readLine();
    String change = br.readLine();

    origin = new boolean[n];
    to = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (original.charAt(i) == '0') {
        origin[i] = true;
      }

      if (change.charAt(i) == '0') {
        to[i] = true;
      }
    }

    int count = 0;
    originSwitchFirst = Arrays.copyOf(origin, n);
    int countSwitchFirst = 0;

    for (int i = 0; i < n; i++) {
      if (i == 0) {
        switching(i, originSwitchFirst);
        countSwitchFirst++;
      } else {
        if (origin[i - 1] != to[i - 1]) {
          switching(i, origin);
          count++;
        }

        if (originSwitchFirst[i - 1] != to[i - 1]) {
          switching(i, originSwitchFirst);
          countSwitchFirst++;
        }
      }

      if (Arrays.equals(origin, to) && Arrays.equals(originSwitchFirst, to)) {
        System.out.println(Math.min(count, countSwitchFirst));
        return;
      }

      if (Arrays.equals(origin, to)) {
        System.out.println(count);
        return;
      }

      if (Arrays.equals(originSwitchFirst, to)) {
        System.out.println(countSwitchFirst);
        return;
      }
    }

    System.out.println(-1);
  }

  private static void switching (int idx, boolean[] array) {
    for (int i = idx - 1; i <= idx + 1; i++) {
      if (i < 0 || i >= array.length) {
        continue;
      }
      array[i] = !array[i];
    }
  }

}
