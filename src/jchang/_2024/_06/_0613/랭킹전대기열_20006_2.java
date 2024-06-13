package jchang._2024._06._0613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 랭킹전대기열_20006_2 {
  // 매칭이 가능한 방 없다면 새로운 방을 생성하고 입장, 처음 입장한 레벨 -10 ~ +10 까지 입장 가능
  // 입장 가능한 방이 있다면 정원이 찰 때까지 대기, 입장 가능한 방이 여러 개면 먼저 생성된 방에 입장
  // 정원이 모두 차면 게임 시작
  // 닉네임 중복 X
  // 출력 : 생성된 방에 대해 게임 시작 유무와 플레이어들의 레벨과 아이디를 출력, 닉네임 사전순으로 출력
  static List<List<Player>> rooms;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int p = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    rooms = new ArrayList<>();
    for (int i = 0; i < p; i++) {
      st = new StringTokenizer(br.readLine());
      int level = Integer.parseInt(st.nextToken());
      String nickName = st.nextToken();

      Player cur = new Player(level, nickName);

      // 입장 가능한 방 있는지 확인 및 입장
      if (rooms.isEmpty()) {
        makeNewRoom(cur);
        continue;
      }

      boolean isEntered = false;
      for (List<Player> room : rooms) {
        int minLevel = room.get(0).level - 10;
        int maxLevel = room.get(0).level + 10;
        if (room.size() < m) {
          if (cur.level >= minLevel && cur.level <= maxLevel) {
            isEntered = true;
            room.add(cur);
            break;
          }
        }
      }

      if (!isEntered) {
        makeNewRoom(cur);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (List<Player> room : rooms) {
      if (room.size() == m) {
        sb.append("Started!").append("\n");
      } else {
        sb.append("Waiting!").append("\n");
      }

      Collections.sort(room, new Comparator<Player>() {
        @Override
        public int compare(Player o1, Player o2) {
          return o1.nickName.compareTo(o2.nickName);
        }
      });
      for (Player player : room) {
        sb.append(player.level).append(" ").append(player.nickName).append("\n");
      }
    }

    System.out.println(sb);
  }

  private static void makeNewRoom(Player player) {
    List<Player> room = new ArrayList<>();
    room.add(player);
    rooms.add(room);
  }

  public static class Player{
    int level;
    String nickName;
    public Player(int level, String nickName) {
      this.level = level;
      this.nickName = nickName;
    }
  }
}
