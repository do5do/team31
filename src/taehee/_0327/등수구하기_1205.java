package taehee._0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등수구하기_1205 {

  static Integer N, score, P;

  static Integer[] ranking;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());

    N = Integer.parseInt(tokenizer.nextToken());
    score = Integer.parseInt(tokenizer.nextToken());
    P = Integer.parseInt(tokenizer.nextToken());
    ranking = new Integer[P];

    if (N == 0) {
      System.out.println(1);
      System.exit(0);
    }

    tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < P; i++) {
      if (tokenizer.hasMoreTokens()) {
        ranking[i] = Integer.parseInt(tokenizer.nextToken());
      } else {
        ranking[i] = -1;
      }
    }

    int rank = -1;
    for (int i = 0; i < P; i++) {
      Integer cur = ranking[i];

      int comp = cur.compareTo(score);
      if (comp <= 0) {
        // 위치가 마지막이고 점수가 같으면 들어갈 수 없음
        if (i == P - 1 && comp == 0) {
          break;
        }

        // 입력 점수가 마지막 점수와 같으면 들어갈 수 없음
        if (score.compareTo(ranking[P - 1]) == 0) {
          break;
        }

        rank = i + 1;
        break;
      }
    }

    System.out.println(rank);
  }
}

// 10 0 10
// 10 9 8 7 6 5 4 3 0 0
// -1

// 8 0 10
// 10 9 8 7 6 5 4 3 -1 -1
// 9

// 25 %
// 10 3 10
// 10 9 8 7 6 5 4 3 3 3
// -1

// 7, 8, 9 -> 3
// N <= P

//4 90 10
//    100 90 90 80
// 2

