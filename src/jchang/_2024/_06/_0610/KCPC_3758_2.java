package jchang._2024._06._0610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class KCPC_3758_2 {
  // k개의 문제
  // 팀 Id, 문제번호, 점수, 제출시간이 순서대로 저장
  // 여러 번 제출 가능, 푼 문제중 최고점수가 최종점수
  // 최종점수 순으로 순위 메김
  // 최종 점수가 같은 경우, 풀이를 제출한 횟수가 적은 팀의 순위가 높음
  // 최종점수, 제출횟수가 같은 경우 마지막 제출시간이 빠른 팀의 순위가 높음
  // 정렬문제
  // 팀별 id, 최종점수, 제출횟수, 제출시간을 기록하여 정렬시키자.
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      solve(br);
    }

    System.out.println(sb);
  }

  // 점수의 경우 문제마다 최종점수를 기록하여야 하기 때문에 문제개수를 입력받아 배열로 초기화 시킨다.
  public static class Team{
    int id;
    int submit;
    int lastSubmitTime;
    int[] scores;
    public Team(int k, int id) {
      this.scores = new int[k + 1];
      this.id = id;
    }
  }

  private static void solve(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // Team 배열 초기화(생성자에 문제 개수, 팀 id를 입력하여 초기화함)
    Team[] teams = new Team[n];
    for (int i = 0; i < n; i++) {
      teams[i] = new Team(k, i + 1);
    }

    // 데이터를 받을 때마다 team의 기록(점수, 제출횟수, 최종 제출순서)를 기록한다.
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int id = Integer.parseInt(st.nextToken());
      int problemNo = Integer.parseInt(st.nextToken());
      int score = Integer.parseInt(st.nextToken());

      Team team = teams[id - 1];
      team.scores[problemNo] = Math.max(team.scores[problemNo], score);
      team.submit++;
      team.lastSubmitTime = i;
    }

    // 문제에 나와있는 기준대로 정렬한다.
    Arrays.sort(teams, new Comparator<Team>() {
      @Override
      public int compare(Team o1, Team o2) {
        int o1Score = Arrays.stream(o1.scores).sum();
        int o2Score = Arrays.stream(o2.scores).sum();
        if (o1Score == o2Score) {
          if (o1.submit == o2.submit) {
            return Integer.compare(o1.lastSubmitTime, o2.lastSubmitTime);
          }
          return Integer.compare(o1.submit, o2.submit);
        }
        return Integer.compare(o2Score, o1Score);
      }
    });

    for (int i = 0; i < teams.length; i++) {
      if (teams[i].id == t) {
        sb.append(i + 1).append("\n");
        return;
      }
    }
  }


}
