package tjoon._202404._0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수이어쓰기_1515 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int value = 1;

    int cur = 0;
    loop:
    while (cur < str.length()) {
      String baseStr = String.valueOf(value);
      for (int i = 0; i < baseStr.length(); i++) {
        if (str.charAt(cur) == baseStr.charAt(i)) {
          cur++;
        }

        if (cur == str.length()) {
          break loop;
        }
      }
      value++;
    }

    System.out.println(value);
  }
}
