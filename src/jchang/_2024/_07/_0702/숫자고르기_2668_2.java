package jchang._2024._07._0702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class 숫자고르기_2668_2 {
  // 세로 두줄, 가로로 N개의 칸
  // 첫째 줄 1, 2, ... , N
  // 둘째 줄 1 이상 N 이하 정수
  // 첫째 줄에서 뽑은 집합과 첫째줄 번호에 대응하는 둘째줄 숫자의 집합이 동일하게 최대한 많은 원소를 뽑을 것
  // 동일한 집합을 유지하기 위해서는 사이클을 이루는 숫자를 뽑아야 한다.
  // ex.
  // 1 2 3 4 5
  // 2 3 1 5 4
  // 위와 같이 숫자가 주어졌을 때 1 -> 2 -> 3 -> 1 이런 식으로 다시 자기 자신의 숫자를 만나면 사이클을 이룬다고 한다.
  static int[] input;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    input = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      input[i] = Integer.parseInt(br.readLine());
    }

    // 결과를 정렬해서 출력해야 하므로 TreeSet을 사용했다.
    Set<Integer> set = new TreeSet<>();

    // 각 인덱스가 사이클을 이루는지 dfs를 이용해 확인하였다.
    for (int i = 1; i <= n; i++) {
      visited = new boolean[n + 1];
      if (dfs(i, i)) {
        set.add(i);
      }
    }


    StringBuilder sb = new StringBuilder();
    sb.append(set.size()).append("\n");
    for (Integer num : set) {
      sb.append(num).append("\n");
    }
    System.out.println(sb);
  }

  private static boolean dfs(int idx, int start) {
    // 탈출조건
    if (input[idx] == start) {
      return true;
    }

    boolean isPass = false;
    if (!visited[idx]) {
      visited[idx] = true;
      isPass = dfs(input[idx], start);
    }

    return isPass;
  }
}
