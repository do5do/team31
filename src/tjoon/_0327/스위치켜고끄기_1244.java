package tjoon._0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치켜고끄기_1244 {

  static int[] switchArr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int switchCount = Integer.parseInt(br.readLine());
    switchArr = new int[switchCount + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i < switchArr.length; i++) {
      switchArr[i] = Integer.parseInt(st.nextToken());
    }

    int P = Integer.parseInt(br.readLine());
    for (int i = 0; i < P; i++) {
      st = new StringTokenizer(br.readLine());
      int gender = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());

      if (gender == 1) {
        for (int j = num; j < switchArr.length; j = j + num) {
          switchButton(switchArr, j);
        }
      } else {
        switchButton(switchArr, num);
        for (int j = 1; (num - j >= 1 && num + j < switchArr.length); j++) {
          if (switchArr[num - j] == switchArr[num + j]) {
            switchButton(switchArr, num - j);
            switchButton(switchArr, num + j);
          } else {
            break;
          }
        }
      }
    }

    for (int i = 1; i < switchArr.length; i++) {
      System.out.print(switchArr[i] + " ");
      if (i % 20 == 0) {
        System.out.println();
      }
    }
  }

  private static void switchButton(int[] arr, int idx) {
    if (arr[idx] == 0) {
      arr[idx] = 1;
    } else {
      arr[idx] = 0;
    }
  }


}
