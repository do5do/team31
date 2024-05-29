package jchang._2024._05._0529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비밀번호발음하기_4659_2 {

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};

    String str;
    while (!(str = br.readLine()).equals("end")) {
      boolean isAcceptable = false;

      loop:
      for (int i = 0; i < str.length(); i++) {
        for (char vowel : vowels) {
          if (str.charAt(i) == vowel) {
            isAcceptable = true;
            break loop;
          }
        }
      }

      if (!isAcceptable) {
        print(false, str);
        continue;
      }

      if (str.length() >= 3) {
        for (int i = 2; i < str.length(); i++) {
          int vowelCount = 0;

          for (int j = i; j >= i - 2; j--) {
            for (char vowel : vowels) {
              if (str.charAt(j) == vowel) {
                vowelCount++;
                break;
              }
            }
          }
          if (vowelCount == 3 || vowelCount == 0) {
            isAcceptable = false;
            break;
          }
        }

        if (!isAcceptable) {
          print(false, str);
          continue;
        }
      }

      if (str.length() >= 2) {
        for (int i = 1; i < str.length(); i++) {
          if ((str.charAt(i) != 'e' && str.charAt(i) != 'o')
              && str.charAt(i - 1) == str.charAt(i)) {
            isAcceptable = false;
            break;
          }
        }

        if (!isAcceptable) {
          print(false, str);
          continue;
        }
      }

      print(true, str);
    }

    System.out.println(sb);
  }

  private static void print(boolean isAcceptable, String str) {
    if (isAcceptable) {
      sb.append("<").append(str).append("> is acceptable.").append("\n");
    } else {
      sb.append("<").append(str).append("> is not acceptable.").append("\n");
    }
  }
}
