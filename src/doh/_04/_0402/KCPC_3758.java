package doh._04._0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KCPC_3758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t > 0) {
            t--;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 팀 개수
            int k = Integer.parseInt(st.nextToken()); // 문제 개수
            int myTeam = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[n];
            int time = 0;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken()) - 1;
                int problemId = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if (teams[teamId] == null) {
                    teams[teamId] = new Team(teamId + 1);
                    teams[teamId].score = new int[k];
                    teams[teamId].score[problemId - 1] = score;
                } else {
                    teams[teamId].score[problemId - 1] = Math.max(score, teams[teamId].score[problemId - 1]);
                }

                teams[teamId].time = time++;
                teams[teamId].cnt++;
            }

            Arrays.sort(teams);

            for (int i = 0; i < n; i++) {
                if (teams[i].idx == myTeam) {
                    sb.append(i + 1).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }

    static class Team implements Comparable<Team> {
        int idx;
        int[] score;
        int total;
        int time;
        int cnt; // 풀이 제출 횟수

        public Team(int idx) {
            this.idx = idx;
        }

        public int compareTo(Team o) {
            total = Arrays.stream(score).sum();
            o.total = Arrays.stream(o.score).sum();

            int result = Integer.compare(o.total, total);
            if (result == 0) {
                result = Integer.compare(cnt, o.cnt);
                if (result == 0) {
                    result = Integer.compare(time, o.time);
                }
            }

            return result;
        }
    }
}
