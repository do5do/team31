package jchang._2024._06._0611;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IF문좀대신써줘_19637_2 {
  // 10,000 이하 WEAK
  // 10,000 초과 100,000이하 NORMAL
  // 100,000 초과 1,000,000이하 STRONG
  // 처음 풀었을 때 시간초과였는데, 문제의 조건에 if 문 조건이 100,000개 까지 가능하기 때문에 이분탐색으로 전환
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 칭호의 문자열 배열과 각 칭호에 해당하는 능력치를 각각 배열로 저장한다.
    String[] grade = new String[n];
    int[] gradePoint = new int[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      grade[i] = st.nextToken();
      gradePoint[i] = Integer.parseInt(st.nextToken());
    }

    // 각 능력치에 맞는 조건을 이분탐색으로 찾는다.
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      int point = Integer.parseInt(br.readLine());

      int min = 0;
      int max = n - 1;
      int result = 0;
      while (min <= max) {
        int mid = (max - min) / 2 + min;

        if (point <= gradePoint[mid]) {
          max = mid - 1;
          result = mid;
        } else {
          min = mid + 1;
        }
      }

      sb.append(grade[result]).append("\n");
    }

    System.out.println(sb);
  }
}
