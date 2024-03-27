package jchang._0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 임스와함께하는미니게임_25757 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    String gameType = st.nextToken();
    int memberCapacity = 0;  // 임스 제외 플레이어 정원
    if (gameType.equals("Y")) {
      memberCapacity = 1;
    } else if (gameType.equals("F")) {
      memberCapacity = 2;
    } else if (gameType.equals("O")) {
      memberCapacity = 3;
    }

    Set<String> game = new HashSet<>();
    Set<String> member = new HashSet<>();
    int play = 0;
    for (int i = 0; i < N; i++) {
      String id = br.readLine();
      if (!member.add(id)) {
        continue;
      }

      game.add(id);
      if (game.size() == memberCapacity) {
        game.clear();
        play++;
      }
    }

    System.out.println(play);
  }
}
