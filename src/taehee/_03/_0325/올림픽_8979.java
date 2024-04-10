package taehee._03._0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 올림픽_8979 {

  static int N, K;
  static Country[] countries;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    N = Integer.parseInt(tokenizer.nextToken());
    K = Integer.parseInt(tokenizer.nextToken());
    countries = new Country[N];
    for (int i = 0; i < N; i++) {
      tokenizer = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(tokenizer.nextToken());
      int gold = Integer.parseInt(tokenizer.nextToken());
      int silver = Integer.parseInt(tokenizer.nextToken());
      int bronze = Integer.parseInt(tokenizer.nextToken());
      countries[i] = new Country(num, gold, silver, bronze);
    }
    Arrays.sort(countries);

    int rank = 1;
    int same = 0;
    for (int i = 0; i < N; i++) {
      Country cur = countries[i];
      Country pre = (i > 0) ? countries[i - 1] : null;

      if (pre != null) {
        if (pre.compareTo(cur) == 0) {
          same++;
        } else {
          same = 0;
        }
      }

      if (cur.num == K) {
        System.out.println(rank - same);
        break;
      }

      rank++;
    }
  }

  static class Country implements Comparable<Country> {

    int num;
    int gold;
    int silver;
    int bronze;

    Country(int num, int gold, int silver, int bronze) {
      this.num = num;
      this.gold = gold;
      this.silver = silver;
      this.bronze = bronze;
    }

    @Override
    public int compareTo(Country o) {
      return comparator.compare(this, o);
    }

    final static Comparator<Country> comparator =
        Comparator.comparingInt((Country c) -> c.gold)
            .thenComparingInt(c -> c.silver)
            .thenComparingInt(c -> c.bronze)
            .reversed();
  }
}

//4 4
//1 0 0 0
//2 0 0 0
//3 0 0 0
//4 0 0 0