package jchang._2024._06._0603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 크로스컨트리_9017_2 {
  // 1. 상위 네명 점수 합산, 동점의 경우 다섯 번째 주자 점수 합산
  // 2. 가장 낮은 점수를 얻은 팀 우승
  // 3. 여섯 명 주자 참가 못 한 팀은 제외
  // 4. 여섯 명 안되는 팀은 점수 없음
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      solve(br);
    }

    System.out.println(sb);
  }

  private static void solve(BufferedReader br) throws IOException {
    int n = Integer.parseInt(br.readLine());
    Map<Integer, Team> map = new HashMap<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] board = new int[n];

    for (int i = 0; i < n; i++) {
      int teamNo = Integer.parseInt(st.nextToken());
      board[i] = teamNo;

      // map.computeIfAbsent는 key가 없을 때 새로운 밸류를 입력한 후 밸류를 다시 return함.
      Team team = map.computeIfAbsent(teamNo, v -> new Team(teamNo));

      team.size++; //팀원 카운트
    }

    // 6명 안 되는 team을 제외하고 Team 객체 안의 list에 점수를 입력(4명 점수, 5명 점수 계산위해 list를 사용함)
    int score = 1;
    for (int i = 0; i < board.length; i++) {
      if (map.get(board[i]).size < 6) {
        continue;
      }
      map.get(board[i]).list.add(score++);
    }

    // 정렬을 위한 PriorityQueue를 만듬
    PriorityQueue<Team> pq = new PriorityQueue<>(new Comparator<Team>() {
      @Override
      public int compare(Team o1, Team o2) {
        if (o1.fourScore == o2.fourScore) {
          return Integer.compare(o1.fiveScore, o2.fiveScore);
        }
        return Integer.compare(o1.fourScore, o2.fourScore);
      }
    });

    // 6명인 팀의 4명 점수, 5명 점수를 계산하여 입력하고 pq에 넣어서 정렬함
    for (Integer key : map.keySet()) {
      Team cur = map.get(key);
      if (cur.size == 6) {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
          sum += cur.list.get(i);
          if (i == 3) {
            cur.fourScore = sum;
          } else if (i == 4) {
            cur.fiveScore = sum;
          }
        }
        pq.add(cur);
      }
    }

    sb.append(pq.poll().teamNo).append("\n");


  }

  public static class Team{
    int teamNo;
    int size;
    List<Integer> list = new ArrayList<>();

    int fourScore;
    int fiveScore;
    public Team(int teamNo) {
      this.teamNo = teamNo;
    }
  }
}
