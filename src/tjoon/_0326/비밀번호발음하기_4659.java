package tjoon._0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비밀번호발음하기_4659 {

  static char[] v = {'a', 'e', 'i', 'o', 'u'};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String str;

    while (!(str = br.readLine()).equals("end")) {
      sb.append("<").append(str).append(">").append(" is ");
      if (includeVowel(str) && continuousThree(str) && sameWord(str)) {
        sb.append("acceptable.\n");
      } else {
        sb.append("not acceptable.\n");
      }
    }

    System.out.println(sb);

  }

  private static boolean includeVowel(String s) {
    for (int i = 0; i < s.length(); i++) {
      for (char c : v) {
        if (s.charAt(i) == c) {
          return true;
        }
      }
    }

    return false;
  }

  private static boolean continuousThree(String s) {

    if (s.length() < 3) {
      return true;
    }

    int vowel = 0;
    int cons = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'a'
          || s.charAt(i) == 'e'
          || s.charAt(i) == 'i'
          || s.charAt(i) == 'o'
          || s.charAt(i) == 'u') {
        vowel++;
        cons = 0;

        if (vowel == 3) {
          return false;
        }
      } else {
        cons++;
        vowel = 0;

        if (cons == 3) {
          return false;
        }
      }
    }

    return true;
  }

  private static boolean sameWord(String s) {
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1)) {
        if (s.charAt(i) != 'e' && s.charAt(i) != 'o') {
          return false;
        }
      }
    }

    return true;
  }

}
