package taehee._04._0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇_20055 {

  static int N, K, L;
  static int[][] conveyor;
  static int kCount = 0;
  static int step = 0;
  static int seq = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    N = Integer.parseInt(tokenizer.nextToken());
    K = Integer.parseInt(tokenizer.nextToken());
    L = N * 2;
    conveyor = new int[L][2];

    tokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < conveyor.length; i++) {
      conveyor[i] = new int[]{0, Integer.parseInt(tokenizer.nextToken())};
    }

    while (kCount < K) {

      if (seq == 0) {
        step++;
        if (conveyor[0][0] == 0 && conveyor[0][1] > 0) {
          conveyor[0][0] = 1;
          conveyor[0][1]--;
          if (conveyor[0][1] == 0) {
            kCount++;
          }
          rotate();
          print();
          seq++;
        } else {
          break;
        }
      } else {
        move();
        print();
        seq = 0;
      }
    }


    System.out.println(step);
  }

  static void rotate() {
    int[] last = conveyor[L - 1];
    for (int i = 0; i < L - 1; i++) {
      if (conveyor[L - 1][0] == 1) {
        conveyor[L - 1][0] = 0;
      }
      conveyor[L - 1 - i] = conveyor[L - 2 - i];
    }
    conveyor[0] = last;
  }

  static void move() {
    for (int i = 0; i < L - 1; i++) {
      if (conveyor[L - 1][0] == 1) {
        conveyor[L - 1][0] = 0;
      }

      int from = L - i - 2;
      int to = L - i - 1;

      if (conveyor[from][0] == 1 && (conveyor[to][0] == 1 || conveyor[to][1] == 0)) {
        continue;
      }

      if (conveyor[from][0] == 1) {
        conveyor[to][0] = conveyor[from][0];
        conveyor[to][1] = conveyor[to][1] - conveyor[to][0];
        conveyor[from][0] = 0;
      }


      if (conveyor[to][0] == 1 && conveyor[to][1] == 0) {
        kCount++;
      }
    }
  }

  static void print() {
    System.out.println("step:" + (step));
    System.out.println("seq:" + (seq + 1));
    for (int i = 0; i < L; i++) {
      System.out.print(conveyor[i][0] + "(" + conveyor[i][1] + ") ");
    }
    System.out.println("\n");
  }
}
