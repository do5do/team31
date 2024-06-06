package jchang._2024._06._0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블로그_21921_2 {
  // 블로그 시작한지 N일
  // X일동안 가장 많이 들어온 방문자 수와 기간을 구하라  --> 부분배열 확인이라 슬라이딩 윈도우
  // 최대 방문자가 0이면 SAD 출력
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    int[] board = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      board[i] = Integer.parseInt(st.nextToken());
    }

    // 처음 윈도우 설정
    int window = 0;
    for (int i = 0; i < x; i++) {
      window += board[i];
    }

    // 배열 순회하며 윈도우 설정(새로운 거 하나 더하고 예전거 하나 빼고) 후 최대값 확인 및 카운트
    int max = window;
    int maxCount = 1;
    for (int i = x; i < n; i++) {
      window = window + board[i] - board[i - x];

      if (window > max) {
        max = window;
        maxCount = 1;
      } else if (window == max) {
        maxCount++;
      }
    }

    if (max == 0) {
      System.out.println("SAD");
    } else {
      System.out.println(max);
      System.out.println(maxCount);
    }
  }
}
