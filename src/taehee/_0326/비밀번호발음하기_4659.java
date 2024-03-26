package taehee._0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 비밀번호발음하기_4659 {

  static Set<Character> aeiouSet = new HashSet<>() {{
    add('a');
    add('e');
    add('i');
    add('o');
    add('u');
  }};

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while (!"end".equals(line = br.readLine())) {
      if (isAcceptable(line)) {
        sb.append(String.format("<%s> is acceptable.", line)).append("\n");
      } else {
        sb.append(String.format("<%s> is not acceptable.", line)).append("\n");
      }
    }
    System.out.println(sb);
  }

  static boolean isAcceptable(String password) {
    boolean containsAEIOU = false;
    int count = 0;

    for (int i = 0; i < password.length(); i++) {
      char cur = password.charAt(i);
      char pre = (i > 0) ? password.charAt(i - 1) : '0';

      if (!containsAEIOU) {
        containsAEIOU = aeiouSet.contains(cur);
      }

      // 자음, 모음 검사
      if (aeiouSet.contains(cur)) {
        // 모음이면 ++
        count = (count < 0) ? 1 : count + 1;
      } else {
        // 자음이면 --
        count = (count > 0) ? -1 : count - 1;
      }

      if (count == 3 || count == -3) {
        return false;
      }

      // 같은 글자 연속으로 a, e 허용
      if (cur == pre && (cur != 'e' && cur != 'o')) {
        return false;
      }
    }

    return containsAEIOU;
  }
}
