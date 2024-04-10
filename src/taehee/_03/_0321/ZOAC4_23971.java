package taehee._03._0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZOAC4_23971 {

  static int H, W, N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    H = Integer.parseInt(tokenizer.nextToken());
    W = Integer.parseInt(tokenizer.nextToken());
    N = Integer.parseInt(tokenizer.nextToken());
    M = Integer.parseInt(tokenizer.nextToken());

    // 거리두기 만큼 나눈 나머지(위치)이 0인 경우에 앉을 수 있다.
    // 1칸인 경우 0, 2, 4 에 앉을 수 있음
    // 2칸인 경우 0, 3, 6 에 앉을 수 있음

//    for (int i = 0; i < H; i++) {
//      for (int j = 0; j < W; j++) {
//        if ((i % (N + 1) == 0) && (j % (M + 1) == 0)) {
//          count++;
//        }
//      }
//    }

    // 거리두기 때문에 1칸은 띄워야 하니까 1씩 증가
    // 5행에 2(1칸 + 1)씩 나누게 되는 경우 몫이 2.5가 되므로 반올림
    int row = (int) Math.ceil(H / (double) (N + 1));
    int col = (int) Math.ceil(W / (double) (M + 1));
    System.out.println(row * col);
  }
}
