package tjoon._202403._0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 크로스컨트리_9017 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {

      // 코드 시작
      Team[] teams = new Team[201];
      int N = Integer.parseInt(br.readLine());
      int[] rank = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int i = 0; i < N; i++) {
        int teamNum = Integer.parseInt(st.nextToken());

        rank[i] = teamNum;

        if (teams[teamNum] == null) {
          teams[teamNum] = new Team(teamNum);
        } else {
          teams[teamNum].players++;
        }
      }

      int curScore = 1;
      for (int i = 0; i < rank.length; i++) {
        int curTeam = rank[i];
        if (teams[curTeam] != null && teams[curTeam].players == 6) {

          if (teams[curTeam].count < 4) { // 아직 4명이 안됐으면
            teams[curTeam].score += curScore; // 그 팀 점수에 현재 인덱스 스코어 더함
            teams[curTeam].count++; // 팀 멤버 수 증가

          } else if (teams[curTeam].count == 4) { // 도착한 멤버가 5명째면
            teams[curTeam].fifthScore = curScore; // 5번째 멤버의 점수 저장
            teams[curTeam].count++; // 팀 멤버 수 증가 -> 안해주면 6번째 선수의 점수를 저장함
          }

          curScore++;
        }
      }

      List<Team> teamList = new ArrayList<>();
      for (int i = 1; i < teams.length; i++) {
        if (teams[i] != null && teams[i].score > 0) {
          teamList.add(teams[i]);
        }
      }

      Collections.sort(teamList);

      System.out.println(teamList.get(0).teamNum);

    }

  }

  static class Team implements Comparable<Team> {

    int teamNum;
    int players = 1;
    int score = 0;
    int count = 0;
    int fifthScore = 0;

    Team(int teamNum) {
      this.teamNum = teamNum;
    }

    @Override
    public int compareTo(Team o) {
      int result = Integer.compare(this.score, o.score);
      if (result == 0) {
        result = Integer.compare(this.fifthScore, o.fifthScore);
      }

      return result;
    }
  }

}
