package tjoon._202404._0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비슷한단어_2607 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String origin = br.readLine();
    int result = 0;

    for (int i = 0; i < N - 1; i++) {

      int[] originArr = new int[26];
      for (int j = 0; j < origin.length(); j++) {
        originArr[origin.charAt(j) - 'A']++;
      }

      String compareStr = br.readLine();
      int sameCnt = 0;
      for (int j = 0; j < compareStr.length(); j++) {
        if (originArr[compareStr.charAt(j) - 'A'] > 0) {
          sameCnt++;
          originArr[compareStr.charAt(j) - 'A']--;
        }
      }

      if (origin.length() == compareStr.length() + 1 && sameCnt == compareStr.length()) {
        result++;
      } else if (origin.length() == compareStr.length() - 1
          && sameCnt == origin.length()) {
        result++;
      } else if (origin.length() == compareStr.length()
          && (sameCnt == origin.length() || sameCnt == origin.length() - 1)) {
        result++;
      }

    }

    System.out.println(result);

  }

}
