package jchang._2024._07._0717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 하늘에서별똥별이빗발친다_14658_2 {

  // 최대한 많은 별똥별을 튕겨내도록 트램펄린을 배치했을 때, 지구에는 몇개의 별똥별이 부딪힐까?
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[][] stars = new int[k][2];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      stars[i] = new int[]{x, y};
    }

    int maxCount = 0;
    for (int i = 0; i < k; i++) {
      int[] star1 = stars[i];
      for (int j = 0; j < k; j++) {
        int[] star2 = stars[j];
        int count = 0;

        for (int[] star : stars) {
          if (star[0] >= star1[0] && star[0] <= star1[0] + l
              && star[1] >= star2[1] && star[1] <= star2[1] + l) {
            count++;
          }
        }
        maxCount = Math.max(count, maxCount);
      }
    }

    System.out.println(k - maxCount);
  }
}
