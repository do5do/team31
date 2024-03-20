package tjoon._0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 전화번호목록_5052 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {

      int n = Integer.parseInt(br.readLine());
      List<String> phoneList = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        phoneList.add(br.readLine());
      }

      Collections.sort(phoneList);

      boolean flag = false;

      for (int i = 0; i < n - 1; i++) {
        if (phoneList.get(i + 1).startsWith(phoneList.get(i))) {
          System.out.println("NO");
          flag = true;
          break;
        }
      }

      if (!flag) {
        System.out.println("YES");
      }

    } // 테스트케이스

  }

}
