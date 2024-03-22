package tjoon._0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합_비트마스크_11723 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int M = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    String op = ""; // 연산
    int x = 0; // 연산 다음 입력값
    String temp = ""; // sb에 넣기 전 temp
    int bit = 0; // 비트 계산

    StringTokenizer st;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      op = st.nextToken();

      if (op.equals("all")) {
        bit |= (~0);
        // ~0 : 111111111...11
        // | 연산으로 모든값 1로 변경
      } else if (op.equals("empty")) {
        bit &= 0;
        // bit 에 무슨 값이 있든 0과 &연산하면 0으로 변경
      } else {
        x = Integer.parseInt(st.nextToken());

        if (op.equals("add")) {
          bit |= (1 << (x - 1));
          // x : 3
          // 1 << (3 - 1) -> 100
          // bit : 011 | 100
          // bit -> 111
        } else if (op.equals("remove")) {
          bit &= ~(1 << (x - 1));
          // x : 3
          // 1 << (3 - 1) -> ~100 -> 011
          // bit : 101 & 011
          // bit -> 001
        } else if (op.equals("check")) {
          temp = (bit & (1 << (x - 1))) != 0 ? "1\n" : "0\n";
          sb.append(temp);
        } else if (op.equals("toggle")) {
          bit ^= (1 << (x - 1));
          // x : 3
          // 1 << (3 - 1) -> 100
          // ^ : XOR
          // 값이 다를때 1 (0, 1)
          // 값이 같을때 0 (1, 1)
        }
      }

    }

    System.out.println(sb);
  }

}


