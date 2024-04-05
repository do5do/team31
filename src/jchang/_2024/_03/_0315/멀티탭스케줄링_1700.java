package jchang._2024._03._0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 멀티탭스케줄링_1700 {

  static int N;
  static int K;
  static int[] problem;
  static boolean[] use = new boolean[101];
  static int count = 0;
  static int put = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st1 = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st1.nextToken());
    K = Integer.parseInt(st1.nextToken());

    problem = new int[K];
    st1 = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      problem[i] = Integer.parseInt(st1.nextToken());
    }

    for (int i = 0; i < K; i++) {
      if (!use[problem[i]]) {
        if (put < N) {
          put++;
          use[problem[i]] = true;
        } else {
          ArrayList<Integer> nextUse = new ArrayList<>();
          for (int j = i; j < K ; j++) {
            if (use[problem[j]] && !nextUse.contains(problem[j])) {
              nextUse.add(problem[j]);
            }
          }

          if (nextUse.size() < N) {
            for (int j = 0; j < use.length; j++) {
              if (use[j] && !nextUse.contains(j)) {
                use[j] = false;
                break;
              }
            }
          } else {
            use[nextUse.get(nextUse.size() - 1)] = false;
          }

          use[problem[i]] = true;
          count++;
        }
      }
    }
    System.out.println(count);
  }
}
