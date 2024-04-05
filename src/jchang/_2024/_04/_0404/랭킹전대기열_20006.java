package jchang._2024._04._0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 랭킹전대기열_20006 {
  static int m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int p = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    List<Room> roomList = new ArrayList<>();
    for (int i = 0; i < p; i++) {
      st = new StringTokenizer(br.readLine());
      int level = Integer.parseInt(st.nextToken());
      String nickname = st.nextToken();

      if (roomList.isEmpty()) {
        Room room = makeNewRoom(level, nickname);
        roomList.add(room);
      } else {
        boolean isJoined = false;
        for (Room room : roomList) {
          if (room.count == m) {
            continue;
          }
          if (level <= room.maxLevel && level >= room.minLevel && room.count < m) {
            room.players.put(nickname, level);
            room.count++;
            isJoined = true;
            break;
          }
        }
        if (!isJoined) {
          roomList.add(makeNewRoom(level, nickname));
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (Room room : roomList) {
      if (room.count == m) {
        room.started = true;
      }
      if (room.started) {
        sb.append("Started!\n");
      } else {
        sb.append("Waiting!\n");
      }
      for (String key : room.players.keySet()) {
        sb.append(room.players.get(key)).append(" ").append(key).append("\n");
      }
    }
    System.out.println(sb);
  }

  private static Room makeNewRoom(int level, String nickname) {
    Room room = new Room();
    room.players.put(nickname, level);
    room.count++;
    room.minLevel = level - 10;
    room.maxLevel = level + 10;
    return room;
  }

  static class Room {
    int count = 0;
    Map<String, Integer> players = new TreeMap<>();
    int minLevel;
    int maxLevel;
    boolean started = false;
  }
}
