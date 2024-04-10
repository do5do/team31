package taehee._04._0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수이어쓰기_1515 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    int N = 0;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < input.length(); i++) {
      String s = String.valueOf(input.charAt(i));

      N++;
      while (!String.valueOf(N).contains(s)) {
        N++;
      }

      sb.delete(0, sb.length());
      sb.append(s);
      boolean flag = false;
      int n = i + 1;
      while (n < input.length()) {
        sb.append(input.charAt(n));

        if (!String.valueOf(N).contains(sb)) {
          flag = true;
          break;
        }

        n++;
        i++;
      }

      if (flag) {
        continue;
      }

      int count = 0;
      int idx = 0;
      String numString = String.valueOf(N);
      while ((idx = numString.indexOf(s, idx) + 1) > 0) {
        count++;
      }
      i += (count - 1);
    }
    System.out.println(N);
  }
}
//1 10 11 12 13 14
// 1 10 11
// 11111
// 1, 10, 11, 12

// 2 12 20 21 22
// 222222
// => 22 o 23 x

// 11111
// 1 10 11 12

