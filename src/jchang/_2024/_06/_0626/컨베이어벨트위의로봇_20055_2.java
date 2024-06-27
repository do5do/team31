package jchang._2024._06._0626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇_20055_2 {
  // 벨트는 길이 1 간격으로 2N개의 칸으로 나누어져서 회전함
  // 칸마다 내구도 있음
  // 1번 칸 올리는 위치, N번 칸 내리는 위치
  // 로봇은 올리는 위치에만 올릴 수 있음.
  // 로봇이 내리는 위치에 도착하면 즉시 내림
  // 로봇은 벨트 위에서 스스로 이동 가능, 로봇이 이동하면 그 칸의 내구도 즉시 1만큼 감소
  // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전
  // 2. 먼저 벨트에 올라간 로봇부터 벨트가 회전하는 방향으로 한칸 이동 가능(이동하려는 칸에 로봇 없고, 내구도가 1이상 남아야 함)하면 이동
  // 3. 올리는 위치 내구도 1이상이면 로봇 올림
  // 4. 내구도가 0인 칸 개수가 k개 이상이면 종료
  // 종료 시 몇번째 단계가 진행중인지 구하라
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    // 1 ~ n까지 컨베이어벨트를 front
    // n + 1 ~ 2n까지 컨베이어 벨트를 back으로 해서 각각 deque를 만듬
    // Belt 객체는 내구성과 로봇 탑승 여부를 나타내는 객체임.
    Deque<Belt> front = new LinkedList<>();
    Deque<Belt> back = new LinkedList<>();

    st = new StringTokenizer(br.readLine());

    // front 해당 데이터 입력
    for (int i = 0; i < n; i++) {
      front.addLast(new Belt(Integer.parseInt(st.nextToken())));
    }

    // back 해당 데이터 입력
    for (int i = 0; i < n; i++) {
      back.addFirst(new Belt(Integer.parseInt(st.nextToken())));
    }

    int stage = 0;  // 각 실행 단계
    int zeroCount = 0;  // 내구성 0인 칸 카운트
    while (zeroCount < k) {
      stage++;

      // 벨트 한칸 회전
      back.addLast(front.removeLast());
      front.addFirst(back.removeFirst());

      // 내리는 장소 도착한 로봇 하차
      front.getLast().robot = false;

      // 로봇 한칸씩 이동(로봇이 존재가능한 벨트 마지막부터 순회하며 이동 가능한지 확인)
      Iterator<Belt> reverseIterator = front.descendingIterator();

      Belt next = reverseIterator.next();

      while (reverseIterator.hasNext()) {
        Belt cur = reverseIterator.next();

        if (cur.robot) {
          if (!next.robot && next.durability != 0) {
            cur.robot = false;
            next.robot = true;
            next.durability--;
            // 내구성이 0이 되는 순간 zeroCount변수에 카운트해줌.
            if (next.durability == 0) {
              zeroCount++;
            }
          }
        }
        next = cur;
      }

      // 내리는 장소 도착한 로봇 하차
      front.getLast().robot = false;

      // 올리는 곳에 내구성 0 이상이면 로봇 올림
      if (front.getFirst().durability != 0) {
        front.getFirst().robot = true;
        front.getFirst().durability--;
        // 내구성이 0이 되는 순간 zeroCount변수에 카운트해줌.
        if (front.getFirst().durability == 0) {
          zeroCount++;
        }
      }
    }

    System.out.println(stage);
  }

  public static class Belt {
    int durability;
    boolean robot = false;
    public Belt(int durability) {
      this.durability = durability;
    }
  }
}
