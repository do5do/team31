package jchang._2024._06._0604;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소_13305_2 {
  // 도시마다 주유소 있음(기름값 다름)
  // 도시를 연결하는 도로 길이 각각 다름
  // 제일 왼쪽에서 오른쪽 도시로 도착하는 최소 비용을 구하라
  // 도시를 쭉 가면서 출발한 곳보다 연료값이 싸면 주유하고 가면 최소 비용으로 간다
  // 입력범위가 거리, 연료가격이 1,000,000,000 이하이기 때문에 가격 * 연료를 하면
  // Integer 범위를 넘어갈 수 있기 때문에 결과값은 Long으로 해야한다.
  static int n;
  static int[] distances;
  static int[] fuels;
  static long result = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    distances = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
      int distance = Integer.parseInt(st.nextToken());
      distances[i] = distance;
    }

    st = new StringTokenizer(br.readLine());
    fuels = new int[n];
    for (int i = 0; i < n; i++) {
      int fuel = Integer.parseInt(st.nextToken());
      fuels[i] = fuel;
    }

    // 마지막으로 주유한 곳의 가격보다 작으면 마지막 주유한 곳의 가격 * 마지막 주유한 곳에서 온 거리를 결과값에 더해줌
    // 그렇지 않다면 마지막 주유한 곳으로부터의 거리만 업데이트 하면 됨
    int preFuel = fuels[0];
    int preDistance = distances[0];
    for (int i = 1; i < n - 1; i++) {
      if (fuels[i] < preFuel) {
        result += (long) preFuel * preDistance;
        preFuel = fuels[i];
        preDistance = distances[i];
      } else {
        preDistance += distances[i];
      }
    }

    // 도착지점에서 마지막 정산한다.
    result += (long) preFuel * preDistance;

    System.out.println(result);
  }


}
