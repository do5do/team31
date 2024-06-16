package jchang._2024._06._0614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 창고다각형_2304_2 {
  // 기둥 폭 1m
  //  1. 지붕은 수평 부분과 수직 부분으로 구성되며, 모두 연결되어야 한다.
  //  2. 지붕의 수평 부분은 반드시 어떤 기둥의 윗면과 닿아야 한다.
  //  3. 지붕의 수직 부분은 반드시 어떤 기둥의 옆면과 닿아야 한다.
  //  4. 지붕의 가장자리는 땅에 닿아야 한다.
  //  5. 비가 올 때 물이 고이지 않도록 지붕의 어떤 부분도 오목하게 들어간 부분이 없어야 한다.
  // 가장 작은 창고 면적
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    // 입력범위가 n이 1이상 1000이하 이기 때문에 기둥을 입력받을 수 있는 배열을 아래와 같이 만든다.
    int[] board = new int[1001];

    // 기둥 입력값을 받으면서 기둥의 높이 최대값과 그 위치를 업데이트 한다.
    int maxIdx = 0;
    int max = 0;
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int l = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());

      board[l] = h;
      if (h > max) {
        maxIdx = l;
        max = h;
      }
    }

    // 왼쪽에서부터 기둥 높이 최대값의 위치까지 기존 기둥의 높이보다 더 높은 기둥의 높이가 나타나면 높이를 새롭게 갱신해주면서 면적을 더한다.
    // ex. 배열이 {0, 3, 5, 6, 2, 0} 이와 같이 구성되어 있으면 높이 최대값은 6이고, 최대값의 인덱스는 3이다.
    //     최초 높이를 0으로 하고, 0번 인덱스부터 최대값의 인덱스 3까지 하나씩 보면 1번 인덱스의 높이가 최초 높이 0보다
    //     크기 때문에 높이를 1번 인덱스의 값인 3으로 갱신하고 2번 인덱스의 높이가 기존 높이 3보다 크기 때문에 5로 갱신하여 누적합을 구한다.
    // 면적의 합은 폭이 1이기 때문에 각 위치의 높이의 합과 같다.
    int result = max;
    int height = 0;
    for (int i = 0; i < maxIdx; i++) {
      if (board[i] > height) {
        height = board[i];
      }
      result += height;
    }

    // 위에서 했던 방법을 오른쪽에서부터 기둥 높이 최대값의 위치까지 하나씩 줄여오면서 반복한다.
    height = 0;
    for (int i = board.length - 1; i > maxIdx; i--) {
      if (board[i] > height) {
        height = board[i];
      }
      result += height;
    }

    System.out.println(result);
  }
}
