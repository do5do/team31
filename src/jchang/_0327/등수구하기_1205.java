package jchang._0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 등수구하기_1205 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int myScore = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    if (N == 0) {
      System.out.println("1");
      System.exit(0);
    }

    int[] scores = new int[P];
    Arrays.fill(scores, -1);
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      scores[i] = Integer.parseInt(st.nextToken());
    }

    int myRank = -1;
    for (int i = 0; i < scores.length; i++) {
      //
      if (myScore > scores[i]) {
        int tempRank = 1;

        for (int j = i - 1; j >= 0 ; j--) {
          if (scores[j] > myScore) {
            tempRank = j + 2;
            break;
          }
        }
        myRank = tempRank;
        break;
      }
    }


    System.out.println(myRank);
  }
}
