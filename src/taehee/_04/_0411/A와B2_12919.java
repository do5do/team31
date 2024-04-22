package taehee._04._0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B2_12919 {

  static StringBuilder S, T;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    S = new StringBuilder(br.readLine());
    T = new StringBuilder(br.readLine());

    int[] S_arr = new int[2];
    int[] T_arr = new int[2];
    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == 'A') {
        S_arr[0]++;
      } else {
        S_arr[1]++;
      }
    }
    for (int i = 0; i < T.length(); i++) {
      if (T.charAt(i) == 'A') {
        T_arr[0]++;
      } else {
        T_arr[1]++;
      }
    }

    int sIdx = 0;
    int tIdx = 0;
    while (S.length() < T.length()) {
      if (sIdx < tIdx) {
        int ch = T.charAt(tIdx);
        if (ch == 'A') {
          S.append('A');
        } else {
          S.append('B');
          S.reverse();
        }
        sIdx++;
        continue;
      }

      char sc = S.charAt(sIdx);
      char tc = T.charAt(tIdx);
      if (sc == tc) {
        sIdx = (sIdx == S.length() - 1) ? sIdx : sIdx + 1;
        tIdx++;
      } else {
        if (sc == 'A') {
          S.append('B');
          S.reverse();
        } else {
          S.append('A');
        }
        sIdx++;
        tIdx++;
      }
    }

    if (S.toString().contentEquals(T.toString())) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }
}

// BAAAAAAAB
// BBAAAAAAAB
