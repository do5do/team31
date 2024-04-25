package jchang._2024._04._0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치_2110 {

  static int[] house;
  static int c;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    house = new int[n];
    for (int i = 0; i < n; i++) {
      house[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(house);

    int left = 1;
    int right = house[n - 1] - house[0];
    int answer = 0;
    while (left <= right) {
      int mid = (right - left) /2 + left;

      if (canInstall(mid)) {
        answer = Math.max(answer, mid);
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    System.out.println(answer);
  }

  private static boolean canInstall(int distance) {
    int lastLocated = house[0];
    int count = 1;
    for (int i = 1; i < house.length; i++) {
      if (house[i] - lastLocated >= distance) {
        count++;
        lastLocated = house[i];
      }
    }
    return count >= c;
  }
}
