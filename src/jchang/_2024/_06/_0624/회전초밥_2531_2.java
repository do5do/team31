package jchang._2024._06._0624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 회전초밥_2531_2 {
  // 벨트 위에는 같은 종류의 초밥이 둘 이상 있을 수 있음
  // 벨트의 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공
  // 초밥의 종류 하나가 쓰인 쿠폰 발행(쿠폰 초밥 무료제공)
  // 초밥 가짓수의 최대값 --> 슬라이딩 윈도우
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int[] belt = new int[n];
    for (int i = 0; i < n; i++) {
      belt[i] = Integer.parseInt(br.readLine());
    }

    // 초밥 가짓수를 카운트하기 위해 map을 하나 만들고 쿠폰으로 받을 초밥접시 번호를 입력한다.
    Map<Integer, Integer> map = new HashMap<>();
    map.put(c, 1);
    // 처음 인덱스 0 ~ k-1까지 슬라이딩 윈도우를 순회하며 초밥접시 번호를 카운트한다.
    for (int i = 0; i < k; i++) {
      map.put(belt[i], map.getOrDefault(belt[i], 0) + 1);
    }

    // map 의 사이즈가 결국 초밥 가짓수가 되기 때문에 result를 map의 사이즈로 초기화한다.
    // ex. map 구성이 1번 접시 : 1개, 2번 접시 : 3개, 3번 접시 : 2개라고 하면 초밥 가짓수는 map의 사이즈인 3이다.
    int result = map.size();
    // 배열을 순회하며 슬라이딩 윈도우에 하나 추가하고 하나 제거하여 계산한다.
    // 단, map의 value가 0이 되면 map.size에서 카운트되지 않도록 map에서 삭제한다.
    for (int i = 1; i < n; i++) {
      // 기존 원소 제거
      map.put(belt[i - 1], map.get(belt[i - 1]) - 1);
      if (map.get(belt[i - 1]) == 0) {
        map.remove(belt[i - 1]);
      }

      // 새로운 원소 추가
      int idx = (i + k - 1) % n;
      map.put(belt[idx], map.getOrDefault(belt[idx], 0) + 1);

      // 결과값 갱신
      result = Math.max(map.size(), result);
    }

    System.out.println(result);
  }
}
