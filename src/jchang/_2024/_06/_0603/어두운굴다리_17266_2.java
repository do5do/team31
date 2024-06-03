package jchang._2024._06._0603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어두운굴다리_17266_2 {
  // 최소한의 높이로 굴다리 모든 길 0~N을 밝혀야 함 --> 최소한의 높이같은 wording이 나오면 이분탐색 고려하자
  // 가로등은 모두 높이가 같음
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    int[] lampSpot = new int[m];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      lampSpot[i] = Integer.parseInt(st.nextToken());
    }

    int min = 1;
    int max = n; // n이 0의 위치에 있을 때는 전부 비추기 위해서 max는 n이 되어야 함

    int answer = 0;
    while (min <= max) {
      int mid = (max - min)/2 + min;

      // 어떻게 램프가 전체 길을 비추고 있는지 확인할 수 있을까?
      // 시간초과 방법 : set(중복방지)을 만들어서 램프가 비추는 index 전부 넣고 0 ~ n까지 set에 다 포함되어 있는지 확인하자
      // 램프가 마지막 비추는 포지션을 저장해가면서 다음 램프가 시작하는 지점이 마지막 포지션보다 작으면 합격, 크면 불합격
      // 램프가 맨 마지막 비추는 포지션이 n보다 작으면 불합격
      // 어떻게 램프가 전체 길을 비추고 있는지 여부를 확인하기 위한 flag를 하나 만들자
      boolean isPass = true;
      int prev = 0;
      for (int spot : lampSpot) {
        if (spot - mid <= prev) {
          prev = spot + mid;
        } else {
          isPass = false;
          break;
        }
      }

      if (prev < n) {
        isPass = false;
      }



      // 이분탐색을 마무리 하자
      if (isPass) {  // 통과하면 최소한의 높이니까 줄이는 방향으로
        max = mid - 1;
        answer = mid; // mid가 마지막 찾은 값이 될 수도 있으니 answer을 계속 갱신한다
      } else {
        min = mid + 1;
      }
    }

    System.out.println(answer);
  }
}

// 이분탐색 범위 지정이 항상 헷갈리는데 마지막 경우를 잘 따져보면 된다.
// 가령 정답이 3인데 min = 2, max = 3이 된 경우 mid는 2이고 min = mid로 업데이트 하면 min이 늘어나지 않기 때문에 무한루프가 된다.
// 그러므로 min 또는 max를 업데이트 할 때는 min = mid + 1, max = mid - 1로 범위를 줄여줘야 된다
