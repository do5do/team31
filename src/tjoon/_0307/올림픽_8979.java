package tjoon._0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 올림픽_8979 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int rank = 0;
    List<Player> players = new ArrayList<>();

    for (int j = 0; j < N; j++) {
      st = new StringTokenizer(br.readLine());

      int num = Integer.parseInt(st.nextToken());
      int gold = Integer.parseInt(st.nextToken());
      int silver = Integer.parseInt(st.nextToken());
      int bronze = Integer.parseInt(st.nextToken());

      players.add(new Player(num, gold, silver, bronze));
    }

    Collections.sort(players);

    int cur = 0;
    for (int i = 0; i < players.size(); i++) {
      if (players.get(i).num == K) {
        rank = i + 1; // 순위
        cur = i; // 해당 index
      }
    }

    for (int i = cur; i > 1; i--) {
      if (players.get(i).gold == players.get(i - 1).gold
          && players.get(i).silver == players.get(i - 1).silver
          && players.get(i).bronze == players.get(i - 1).bronze) {
        rank--;
      } else {
        break;
      }
    }

    System.out.println(rank);
  }

  static class Player implements Comparable<Player> {

    int num;
    int gold;
    int silver;
    int bronze;

    Player(int num, int gold, int silver, int bronze) {
      this.num = num;
      this.gold = gold;
      this.silver = silver;
      this.bronze = bronze;
    }

    @Override
    public int compareTo(Player o) {
      int result = Integer.compare(o.gold, this.gold);

      if (result == 0) {
        result = Integer.compare(o.silver, this.silver);

        if (result == 0) {
          result = Integer.compare(o.bronze, this.bronze);
        }
      }

      return result;
    }
  }
}
