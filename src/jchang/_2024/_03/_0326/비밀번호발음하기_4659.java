package jchang._2024._03._0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 비밀번호발음하기_4659 {

  static List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    while (!str.equals("end")) {
      boolean isPass = true;
      int vowel = 0;
      List<Character> checkTriple = new ArrayList<>();
      for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (vowels.contains(c)) {
          vowel++;
        }

        // 자음 모음 3연속 체크
        checkTriple.add(c);
        if (checkTriple.size() >= 3) {
          if (checkTriple.size() > 3) {
            checkTriple.remove(0);
          }
          int vowelCounter = 0;
          int consonantCounter = 0;
          for (Character ch : checkTriple) {
            if (vowels.contains(ch)) {
              vowelCounter++;
            } else {
              consonantCounter++;
            }
          }

          if (consonantCounter == 3 || vowelCounter == 3) {
            isPass = false;
            break;
          }
        }

        // 2연속 반복 문자 체크
        if (checkTriple.size() >= 2 &&
            checkTriple.get(checkTriple.size() - 1) == checkTriple.get(
                checkTriple.size() - 2)) {
          if (!(c == 'e' || c == 'o')) {
            isPass = false;
            break;
          }
        }

      }

      // 모음 하나 이상 존재하는지 체크
      if (vowel == 0) {
        isPass = false;
      }

      if (isPass) {
        System.out.printf("<%s> is acceptable.\n", str);
      } else {
        System.out.printf("<%s> is not acceptable.\n", str);
      }

      str = br.readLine();
    }
  }
}
