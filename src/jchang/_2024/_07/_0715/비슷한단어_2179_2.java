package jchang._2024._07._0715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비슷한단어_2179_2 {
  // N개의 영단어가 주어짐
  // 두 단어의 비슷한 정도는 접두사의 길이로 측정
  // 접두사의 길이가 최대인 경우가 여러 개일 땐 입력 순서대로 제일 앞쪽 단어가 답이다.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] input = new String[n];
    for (int i = 0; i < n; i++) {
      input[i] = br.readLine();
    }

    String[] answer = new String[2];
    int maxSame = 0;
    for (int i = 0; i < n; i++) {
      String target = input[i];
      for (int j = i + 1; j < n; j++) {
        int prefixCount = 0;
        String cur = input[j];
        for (int k = 0; k < Math.min(target.length(), cur.length()); k++) {
          if (target.charAt(k) != cur.charAt(k)) {
            break;
          }
          prefixCount++;
        }

        if (prefixCount > maxSame) {
          maxSame = prefixCount;
          answer[0] = target;
          answer[1] = cur;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (String str : answer) {
      sb.append(str).append("\n");
    }
    System.out.println(sb);
  }
}
