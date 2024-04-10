package tjoon._202404._0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 볼모으기_17615 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    char[] ball = new char[n];

    int redCnt = 0;
    int blueCnt = 0;
    String str = br.readLine();
    for (int i = 0; i < n; i++) {
      ball[i] = str.charAt(i);

      if (ball[i] == 'R') {
        redCnt++;
      } else {
        blueCnt++;
      }

    }

    int ans = Integer.MAX_VALUE;
    int firstCnt = 0;
    for (int i = 0; i < n; i++) {
      if (ball[i] == 'R') {
        firstCnt++;
      } else {
        break; // B가 나오면 스탑
      }
    }

    ans = Math.min(ans, redCnt - firstCnt);

    firstCnt = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (ball[i] == 'R') {
        firstCnt++;
      } else {
        break; // B가 나오면 스탑
      }
    }

    ans = Math.min(ans, redCnt - firstCnt);

    firstCnt = 0;
    for (int i = 0; i < n; i++) {
      if (ball[i] == 'B') {
        firstCnt++;
      } else {
        break; // R이 나오면 스탑
      }
    }

    ans = Math.min(ans, blueCnt - firstCnt);

    firstCnt = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (ball[i] == 'B') {
        firstCnt++;
      } else {
        break; // R이 나오면 스탑
      }
    }

    ans = Math.min(ans, blueCnt - firstCnt);

    System.out.println(ans);
  }

}
