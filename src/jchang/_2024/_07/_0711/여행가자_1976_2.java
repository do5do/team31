package jchang._2024._07._0711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 여행가자_1976_2 {
  // 도시 N개가 있고, 여행계획을 충족시킬 수 있는지 여부 반환
  // 인접리스트를 구성하고
  // 여행 계획의 순서대로 방문해야 하기 때문에, dfs를 통해 여행 계획의 각 도시에서 다음 장소로 이동 가능한지 확인한다.
  static int n, m;
  static List<List<Integer>> list;
  static int[] travelPlan;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    // 인접리스트 초기화
    list = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      list.add(new ArrayList<>());
    }

    // 인접리스트 구성
    StringTokenizer st = null;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        int canGo = Integer.parseInt(st.nextToken());
        if (canGo == 1) {
          list.get(i + 1).add(j + 1);
        }
      }
    }

    // 여행 계획을 배열로 입력 받는다.
    st = new StringTokenizer(br.readLine());
    travelPlan = new int[m];
    for (int i = 0; i < m; i++) {
      travelPlan[i] = Integer.parseInt(st.nextToken());
    }

    boolean result = true;
    // 여행 계획 배열을 순회하며 각 도시에서 다음 도시로 갈 수 있는 지 확인한다.
    // 다음 도시로 갈 수 없다면 결과는 false로 반복문을 종료한다.
    for (int i = 0; i < m - 1; i++) {
      visited = new boolean[n + 1];
      if (!dfs(travelPlan[i], travelPlan[i + 1])) {
        result = false;
        break;
      }
    }

    if (result) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

  private static boolean dfs(int start, int end) {
    // 탈출조건 : 도착장소와 출발하는 장소가 일치하면 true를 반환한다.
    if (start == end) {
      return true;
    }

    // 중복 방문을 피하기 위해 visit 배열로 방문 도시는 true로 한다.
    visited[start] = true;

    // 출발장소에서 갈 수 있는 도시를 탐색한다.
    List<Integer> cur = list.get(start);
    for (Integer candidate : cur) {
      // 방문한 적 없는 도시만 방문한다.
      if (!visited[candidate]) {
        // 재귀함수 결과가 true면 바로 true를 반환한다.
        if (dfs(candidate, end)) {
          return true;
        }
      }
    }

    // 위 과정에서 true가 반환되지 않았다면 false를 반환한다.
    return false;
  }
}
