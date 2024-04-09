package taehee._0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 볼모으기_17615 {

  static int blue, red;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String balls = br.readLine();
    char[] charArray = balls.toCharArray();
    for (char ch : charArray) {
      if (ch == 'B') {
        blue++;
      } else if (ch == 'R') {
        red++;
      }
    }
    
    char left = charArray[0], right = charArray[N - 1];
    int leftCount = 1, rightCount = 1;
    boolean leftRepeat = true, rightRepeat = true;

    for (int i = 1; i < N / 2; i++) {
      if (leftRepeat && left == charArray[i]) {
        leftCount++;
      } else {
        leftRepeat = false;
      }

      if (rightRepeat && right == charArray[N - 1 - i]) {
        rightCount++;
      } else {
        rightRepeat = false;
      }
    }

    if (leftRepeat && !rightRepeat) {
      if (left == 'R') {
        System.out.println(blue);
      } else {
        System.out.println(red);
      }
    } else if (!leftRepeat && rightRepeat) {
      if (left == 'R') {
        System.out.println(blue);
      } else {
        System.out.println(red);
      }
    }
  }
}
