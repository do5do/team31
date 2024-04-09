package tjoon._202403._0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어공부_1157 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    int[] alpha = new int[26];

    for (int i = 0; i < s.length(); i++) {
      int ch = Character.toUpperCase(s.charAt(i)) - 'A';
      alpha[ch]++;
    }

    int idx = 0;
    int max = 0;
    for (int i = 0; i < alpha.length; i++) {
      if (alpha[i] > max) {
        max = alpha[i];
        idx = i;
      }
    }

    boolean flag = false;
    for (int i = 0; i < alpha.length; i++) {
      if (i != idx && alpha[i] == max) {
        System.out.println("?");
        flag = true;
        break;
      }
    }

    if (!flag) {
      System.out.println((char) (idx + 'A'));
    }

  }

}
