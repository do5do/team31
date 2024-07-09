package jchang._2024._07._0709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치_2110_2 {
  // 집 N개가 수직선 위에 있다.
  // 공유기 C개를 설치하려고 한다.
  // 한 집에 공유기 하나 설치 가능
  // 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치
  // 가장 인접한 두 공유기 사이의 최대 거리를 구하라
  // 문제 이해가 안 되서 풀어쓰면
  // '배열 안에서 인접한 두 공유기 거리의 최소값'이 최대가 되게
  // 배열 안에서 인접한 두 공유기 거리의 최소값 : 2
  // 1 2 4 8 9
  // O   O O  <-- 3개 설치 가능
  // 배열 안에서 인접한 두 공유기 거리의 최소값 : 3
  // 1 2 4 8 9
  // O   O O  <-- 3개 설치 가능
  // 배열 안에서 인접한 두 공유기 거리의 최소값 : 4
  // 1 2 4 8 9
  // O     O   <-- 2개만 설치 가능해서 탈락
  // 따라서 '배열 안에서 인접한 두 공유기 거리의 최소값'을 이분탐색으로 찾아준다.
  static int[] houses;
  static int n, c;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    houses = new int[n];
    for (int i = 0; i < n; i++) {
      houses[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(houses);

    int max = houses[n - 1] - houses[0];
    int min = 1;
    int result = 0;
    while (min <= max) {
      int mid = (max - min) / 2 + min;
      // 설치 가능 대수
      int counter = counter(mid);

      // 설치 가능 대수가 c를 넘으면 통과
      if (counter >= c) {
        result = Math.max(result, mid);
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }

    System.out.println(result);
  }

  private static int counter(int mid) {
    int pre = houses[0];
    int count = 1;
    for (int i = 1; i < n; i++) {
      if (houses[i] - pre >= mid) {
        count++;
        pre = houses[i];
      }
    }

    return count;
  }
}
