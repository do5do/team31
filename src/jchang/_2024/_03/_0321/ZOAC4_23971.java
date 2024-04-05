package jchang._2024._03._0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZOAC4_23971 {
  static int H;
  static int W;
  static int N;
  static int M;
//  static boolean[][] room;
//  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken()) + 1; // 세로줄 i
    M = Integer.parseInt(st.nextToken()) + 1; // 가로줄 j
    int result = 0;
    int a = H / N;
    int b = W / M;

    if (H % N != 0) {
      a++;
    }
    if (W % M != 0) {
      b++;
    }
    result = a * b;

    System.out.println(result);

    // 메모리 초과..
//    room = new boolean[H][W];
//
//    for (int i = 0; i < H; i++) {
//      for (int j = 0; j < W; j++) {
//        if (!room[i][j]) {
//          haveSeat(i, j);
//        }
//      }
//    }
//
//    System.out.println(count);

  }

//  public static void haveSeat(int x, int y) {
//    for (int i = x; i <= Math.min(x + N, H - 1); i++) {
//      for (int j = y; j <= Math.min(y + M, W - 1); j++) {
//        room[i][j] = true;
//      }
//    }
//    count++;
//  }


}
