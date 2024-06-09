package jchang._2024._06._0607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진우의달여행_17484_2 {
  // N X M 행렬 : 원소는 공간 지나갈 때 소모되는 연료의 양
  // / ㅣ \ 방향으로 이동
  // 전에 이동한 같은 방향으로는 이동 불가
  // 연료 최소값  --> 과거의 선택이 지금의 선택에 영향을 끼치니 dfs
  static int n, m;
  static int[][] board;
  static int result = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < m; i++) {
      // 최초에는 전에 이동했던 방향이 존재하지 않기 때문에 이동할 수 있는 방향(-1, 0, 1)을 제외하고 아무 값이나 넣어준다.
      dfs(0, 1000, 0, i);
    }

    System.out.println(result);
  }

  // sum은 지나가는 곳의 연료의 합, preDirection은 전에 이동했던 방향(-1, 0, 1), stage는 행의 인덱스, idx는 열의 인덱스
  private static void dfs(int sum, int preDirection, int stage, int idx) {
    // 탈출조건 : 열의 인덱스인 stage가 n가 같아지면 결과값(연료의 합)의 최소값을 업데이트한다.
    if (stage == n) {
      result = Math.min(result, sum);
      return;
    }

    // 방문한 곳의 연료를 더한다.
    sum += board[stage][idx];
    // 3가지 방향(-1, 0, 1)을 방문하는데
    for (int i = -1; i <= 1; i++) {
      // 전에 이동한 방향이랑 다른 경우만 방문한다.
      if (i != preDirection) {
        // 단 이동하려는 방향은 배열의 범위 내에 있어야 한다.
        if (idx + i >= 0 && idx + i < m) {
          dfs(sum, i, stage + 1, idx + i);
        }
      }
    }
  }
}
