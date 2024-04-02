package tjoon._0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타노스_20310 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] strArr = br.readLine().toCharArray();

    int one = 0;
    int zero = 0;
    for (int i = 0; i < strArr.length; i++) {
      if (strArr[i] == '1') {
        one++;
      } else {
        zero++;
      }
    }

    one /= 2;
    zero /= 2;

    for (int i = 0; i < strArr.length; i++) {
      if (one != 0 && strArr[i] == '1') {
        one--;
        strArr[i] = '-';
      }
    }

    for (int i = strArr.length - 1; i >= 0; i--) {
      if (zero != 0 && strArr[i] == '0') {
        zero--;
        strArr[i] = '-';
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strArr.length; i++) {
      if (strArr[i] != '-') {
        sb.append(strArr[i]);
      }
    }

    System.out.println(sb);

  }

}
