package jchang._2024._05._0513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 하늘에서별똥별이빗발친다_14658 {

  static int n, m, l, k;
  static Star[] stars;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    l = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    stars = new Star[k];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      stars[i] = new Star(a, b);
    }

    int result = 0;
    for (Star star1 : stars) {
      for (Star star2 : stars) {
        int count = 0;
        for (Star target : stars) {
          if (target.x >= star1.x && target.x <= star1.x + l && target.y >= star2.y
              && target.y <= star2.y + l) {
            count++;
          }
        }
        result = Math.max(result, count);
      }
    }

    System.out.println(k - result);

  }

  static class Star {

    int x, y;

    public Star(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
