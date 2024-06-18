package jchang._2024._06._0617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 한줄로서기_1138_2 {
  // N명의 사람이 한줄로 선다.
  // 사람들의 키는 모두 다르다
  // 사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있는지 기억함
  // 사람들은 자기보다 키 큰 사람이 왼쪽에 몇 명 있는지 기억하기 때문에 키 큰 사람의 위치에 따라 본인의 위치가 결정된다.
  // 따라서 키 큰 사람의 위치를 먼저 확정하는 것이 본인의 위치가 변동할 가능성이 줄어든다.
  // 그리고 키 큰 사람부터 위치를 정할 경우 키 큰 사람이 본인 때문에 한칸 물러서도 조건을 깨뜨리는 일은 없다.
  // ex. 2 1 1 0으로 입력값이 주어져 키가 3인 사람이 1번 인덱스에 들어가있다면 키가 2인 사람이 1번 인덱스로 들어가고 싶은 경우
  // 키가 3인 사람을 한칸 뒤로 밀고 키가 2인 사람이 1번 인덱스에 들어가면 조건을 만족한다.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] input = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      input[i] = Integer.parseInt(st.nextToken());
    }

    List<Integer> result = new ArrayList<>();
    for (int i = n - 1; i >= 0; i--) {
      int height = i + 1;
      int idx = input[i];
      result.add(idx, height);
    }

    StringBuilder sb = new StringBuilder();
    for (int num : result) {
      sb.append(num).append(" ");
    }
    System.out.println(sb);
  }
}
