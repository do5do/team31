package jchang._2024._06._0607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거분배_19941_2 {
  // 사람들은 자신의 위치에서 거라가 K 이하인 햄버거 먹을 수 있음
  // 햄버거를 먹을 수 있는 사람의 최대 수 --> 여러 경우 중 최대인 경우 : 그리디?
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    char[] board = br.readLine().toCharArray();
    // 왼쪽의 가장 먼 것부터 오른쪽 가장 먼 것까지 먹을 수 있는게 있는지 보고 먹는다
    // 제일 왼쪽에 있는 것부터 먹어야 다음 사람이 먹을 확률이 높아지기 때문에 왼쪽의 가장 먼 것부터 오른쪽 가장 먼 것까지 탐색
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (board[i] == 'P') {
        for (int j = i - k; j <= i + k; j++) {
          if (j < 0 || j >= n) {
            continue;
          }

          if (board[j] == 'H') {
            count++;
            board[j] = 'X';
            break;
          }
        }
      }
    }

    System.out.println(count);
  }
}
