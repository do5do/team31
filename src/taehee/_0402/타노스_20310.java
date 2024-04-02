package taehee._0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타노스_20310 {

  static String S;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    S = br.readLine();

    char[] charArray = S.toCharArray();
    int[] count = new int[2];
    for (char ch : charArray) {
      count[(ch == '0') ? 0 : 1]++;
    }

    int oneCount = count[1] / 2;
    for (int i = 0; i < charArray.length; i++) {
      if (charArray[i] == '1') {
        count[1]--;
        charArray[i] = '\0';
      }
      if (oneCount == count[1]) {
        break;
      }
    }

    int zeroCount = count[0] / 2;
    for (int i = charArray.length - 1; i >= 0; i--) {
      if (charArray[i] == '0') {
        count[0]--;
        charArray[i] = '\0';
      }
      if (zeroCount == count[0]) {
        break;
      }
    }

    for (char ch : charArray) {
      if (ch != '\0')
        sb.append(ch);
    }

    System.out.println(sb);
  }
}
// 0 1
// // 1>> <<0