package jchang._0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타노스_20310 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    int zero = 0;
    int one = 0;
    char[] array = str.toCharArray();
    for (char c : array) {
      if (c == '0') {
        zero++;
      } else {
        one++;
      }
    }

    zero = zero/2;
    one = one/2;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == '1') {
        one--;
        array[i] = 'X';
      }
      if (one == 0) {
        break;
      }
    }

    for (int i = array.length - 1; i >= 0; i--) {
      if (array[i] == '0') {
        zero--;
        array[i] = 'X';
      }
      if (zero == 0) {
        break;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (char ch : array) {
      if (ch != 'X') {
        sb.append(ch);
      }
    }
    System.out.println(sb);
  }


}
