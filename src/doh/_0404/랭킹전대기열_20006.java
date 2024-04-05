package doh._0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 랭킹전대기열_20006 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 정원

        List<Room> rooms = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            boolean join = false;

            for (Room room : rooms) {
                if (room.players.size() != m && level >= room.level - 10 && level <= room.level + 10) {
                    join = true;
                    room.addPlayer(level, nickname);
                    break;
                }
            }

            if (!join) {
                Room room = new Room(level);
                room.addPlayer(level, nickname);
                rooms.add(room);
            }
        }

        for (Room room : rooms) {
            if (room.players.size() == m) {
                room.status = "Started!";
            }
            sb.append(room.status).append("\n");
            sb.append(String.join("\n", room.players.values())).append("\n");
        }

        System.out.println(sb);
    }

    static class Room {
        Map<String, String> players = new TreeMap<>();
        String status = "Waiting!";
        int level;

        public Room(int level) {
            this.level = level;
        }

        public void addPlayer(int level, String nickname) {
            players.put(nickname, level + " " + nickname);
        }
    }
}
