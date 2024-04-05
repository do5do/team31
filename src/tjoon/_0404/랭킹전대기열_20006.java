package tjoon._0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 랭킹전대기열_20006 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int p = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    List<Room> rooms = new ArrayList<>();

    for (int i = 0; i < p; i++) {
      st = new StringTokenizer(br.readLine());

      int level = Integer.parseInt(st.nextToken());
      String name = st.nextToken();

      boolean flag = false;
      for (Room room : rooms) {
        if (room.players.size() != m) {
          if (!room.players.isEmpty()
              && room.players.get(0).level - 10 <= level
              && room.players.get(0).level + 10 >= level) {
            flag = true;
            room.players.add(new Player(name, level));
            break;
          }
        }
      }

      if (!flag) {
        Room room = new Room();
        room.players.add(new Player(name, level));
        rooms.add(room);
      }

    }

    for (Room room : rooms) {
      Collections.sort(room.players);
      if (room.players.size() == m) {
        sb.append("Started!").append("\n");
      } else {
        sb.append("Waiting!").append("\n");
      }
      for (int i = 0; i < room.players.size(); i++) {
        int level = room.players.get(i).level;
        String nickName = room.players.get(i).nickname;

        sb.append(level).append(" ").append(nickName).append("\n");
      }
    }

    System.out.println(sb);

  }

  static class Player implements Comparable<Player> {

    String nickname;
    int level;

    public Player(String nickname, int level) {
      this.nickname = nickname;
      this.level = level;
    }

    @Override
    public int compareTo(Player o) {
      return this.nickname.compareTo(o.nickname);
    }
  }

  static class Room {

    List<Player> players = new ArrayList<>();
  }

}
