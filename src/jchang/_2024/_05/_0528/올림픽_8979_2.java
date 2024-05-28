package jchang._2024._05._0528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 올림픽_8979_2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Nation[] nations = new Nation[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      int gold = Integer.parseInt(st.nextToken());
      int silver = Integer.parseInt(st.nextToken());
      int bronze = Integer.parseInt(st.nextToken());
      nations[i] = new Nation(num, gold, silver, bronze);
    }

    Arrays.sort(nations, new Comparator<Nation>() {
      @Override
      public int compare(Nation o1, Nation o2) {
        if (o1.gold == o2.gold) {
          if (o1.silver == o2.silver) {
            return Integer.compare(o2.bronze, o1.bronze);
          }
          return Integer.compare(o2.silver, o1.silver);
        }
        return Integer.compare(o2.gold, o1.gold);
      }
    });

    int rank = 1;
    if (k == nations[0].num) {
      System.out.println(1);
      return;
    }

    for (int i = 1; i < nations.length; i++) {
      if (!nations[i].equal(nations[i - 1])) {
        rank = i + 1;
      }

      if (nations[i].num == k) {
        System.out.println(rank);
        return;
      }
    }


  }

  public static class Nation {

    int num, gold, silver, bronze;

    public Nation(int num, int gold, int silver, int bronze) {
      this.num = num;
      this.gold = gold;
      this.silver = silver;
      this.bronze = bronze;
    }

    public boolean equal(Nation nation) {
      return this.gold == nation.gold && this.silver == nation.silver
          && this.bronze == nation.bronze;
    }
  }
}
