package taehee._04._0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열교환_1522 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    char[] charArray = str.toCharArray();

    int count = 0;

    for (int i = 0; i < charArray.length; i++) {
      int next = (i == charArray.length - 1) ? 0 : i + 1;
      int prev = (i == 0) ? charArray.length - 1 : i - 1;

      if (next == prev) {
        continue;
      }

      // 현재문자를 기준으로 이전과 다음 문자가 'a'면 연속된 문자니까 그냥 지나침..
      if (charArray[i] == 'a' && (charArray[next] == 'a' || charArray[prev] == 'a')) {
        continue;
      }


    }
  }
}

// a 8 b 7
// abababababababa 3
// a(b)ababab abab(a)ba 1
// aaa(b)abab ab(a)bbba 2
// aaaaa(b)ab (a)bbbbba 3
// aaaaaaab bbbbbba

// ab ab
// a(b) (a)b

// ba ba
//

// aaaabbbbba


// a 8 b 4
// aa(b)baaab a(a)ba
// aaa(b)aaab (a)bba
// aaaaaaab bbba
//
