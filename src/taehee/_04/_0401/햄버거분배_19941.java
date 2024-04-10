package taehee._04._0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 햄버거분배_19941 {

  static int N, K;
  static boolean[] hamburgers;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    N = Integer.parseInt(tokenizer.nextToken());
    K = Integer.parseInt(tokenizer.nextToken());
    hamburgers = new boolean[N];

    List<Integer> persons = new ArrayList<>();
    String input = br.readLine();
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == 'P') {
        persons.add(i);
      } else {
        hamburgers[i] = true;
      }
    }

    int count = 0;
    loop:
    for (Integer pos : persons) {
      for (int i = pos - K; i <= pos + K; i++) {
        if (i >= 0 && i < N && hamburgers[i]) {
          hamburgers[i] = false;
          count++;
          continue loop;
      }
//      for (int i = K; i >= 1; i--) {
//        int left = pos - i;
//        if (left >= 0 && left < N && hamburgers[left]) {
//          hamburgers[left] = false;
//          count++;
//          continue loop;
//        }
//
//        int right = pos + i;
//        if (right >= 0 && right < N && hamburgers[right]) {
//          hamburgers[right] = false;
//          count++;
//          continue loop;
//        }
      }
    }

    System.out.println(count);
  }
}

//           5 6   8     11   9   10      11
// H H H H H P P P P P H P H P H P H H H P
//       a b a b   c   c d d e e f   f g g

// K
// H H P H H P H H

// a b   a b
// P P H H H H P P


// PPHHHHPP