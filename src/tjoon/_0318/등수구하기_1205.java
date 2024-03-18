package tjoon._0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 등수구하기_1205 {

  static int N, score, rankCount;
  static int[] scoreArr;
  static int idx = -1;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());

    if (N == 0) {
      System.out.println(1);
      System.exit(0);
    }

    score = Integer.parseInt(st.nextToken());
    rankCount = Integer.parseInt(st.nextToken());

    scoreArr = new int[rankCount];
    Arrays.fill(scoreArr, -1); // 점수는 0부터 시작

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      scoreArr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < rankCount; i++) {
      if (scoreArr[i] < score) {
        idx = i;
        break;
      }
    }

    if (idx == -1) {
      System.out.println(-1);
      System.exit(0);
    }

    int[] temp = new int[rankCount];
    for (int i = 0; i < idx; i++) {
      temp[i] = scoreArr[i];
    }
    temp[idx] = score;
    for (int i = idx + 1; i < rankCount; i++) {
      temp[i] = scoreArr[i - 1];
    }

    int rank = 0;
    int same = 0;
    for (int i = 0; i < temp.length; i++) {
      if (temp[i] > score) {
        rank++;
      } else if (temp[i] == score) {
        rank++;
        same++;
      } else {
        break;
      }
    }

    System.out.println(rank - same + 1);

  }

}
