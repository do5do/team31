package doh._0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 크로스컨트리_9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            Map<Integer, Team> teamMap = new HashMap<>();
            int[] input = new int[n]; // team 순서 저장

            for (int j = 0; j < n; j++) {
                int teamId = Integer.parseInt(st.nextToken());

                input[j] = teamId;
                teamMap.putIfAbsent(teamId, new Team(teamId));
                if (teamMap.containsKey(teamId)) {
                    teamMap.get(teamId).total++;
                }
            }

            // 점수 계산
            int cnt = 0;
            List<Team> selected = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                Team cur = teamMap.get(input[j]);

                if (cur.total >= 6) {
                    cnt++;
                    cur.count++;

                    if (cur.count <= 4) {
                        cur.sum += cnt;
                    } else if (cur.count == 5) {
                        cur.fifth = cnt;
                    } else if (cur.count == 6) {
                        selected.add(cur);
                    }
                }
            }

            Collections.sort(selected);
            sb.append(selected.get(0).id).append("\n");
        }

        System.out.println(sb);
    }

    static class Team implements Comparable<Team> {
        int id;
        int sum;
        int fifth;
        int count;
        int total;

        public Team(int id) {
            this.id = id;
        }

        public int compareTo(Team o) {
            int result = Integer.compare(sum, o.sum);
            if (result == 0) {
                result = Integer.compare(fifth, o.fifth);
            }
            return result;
        }
    }
}
