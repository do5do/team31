package tjoon._0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기_1759 {

  static int l;
  static int c;
  static String[] alpha;
  static String[] pwd;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    l = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    alpha = new String[c];
    pwd = new String[l];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < c; i++) {
      alpha[i] = st.nextToken();
    }

    Arrays.sort(alpha);

    dfs(0, 0);

  }

  private static void dfs(int index, int start) {

    if (index == l) {
      int consonant = 0;
      int vowel = 0;

      for (String s : pwd) {
        if (s.equals("a") || s.equals("e") || s.equals("i")
            || s.equals("o") || s.equals("u")) {
          vowel++;
        } else {
          consonant++;
        }
      }

      if (vowel >= 1 && consonant >= 2) {
        for (String s : pwd) {
          System.out.print(s);
        }
        System.out.println();
      }
      return;
    }

    for (int i = start; i < c; i++) {
      pwd[index] = alpha[i];
      dfs(index + 1, i + 1);
    }

  }

}
