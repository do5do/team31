package jchang._2024._07._0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비슷한단어_2179_3 {
  // 같은 접두사의 문자열 길이가 가장 긴 것을 찾자
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] input = new String[n];
    for (int i = 0; i < n; i++) {
      input[i] = br.readLine();
    }

    String[] answer = new String[2];
    int maxCount = 0;
    for (int i = 0; i < n; i++) {
      String str1 = input[i];
      for (int j = i + 1; j < n; j++) {
        int count = 0;
        String str2 = input[j];
        if (str1.equals(str2)) {
          break;
        }

        for (int k = 0; k < Math.min(str1.length(), str2.length()); k++) {
          if (str1.charAt(k) == str2.charAt(k)) {
            count++;
          } else {
            break;
          }
        }

        if (count > maxCount) {
          maxCount = count;
          answer[0] = str1;
          answer[1] = str2;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (String string: answer) {
      sb.append(string).append("\n");
    }
    System.out.println(sb);
  }
}
