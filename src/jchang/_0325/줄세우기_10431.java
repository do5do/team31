package jchang._0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 줄세우기_10431 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int P = Integer.parseInt(br.readLine());
    int[] result = new int[P];

    for (int i = 0; i < P; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      List<Integer> problem = new ArrayList<>();
      problem.add(Integer.parseInt(st.nextToken()));
      int sum = 0;

      for (int j = 0; j < 19; j++) {
        int input = Integer.parseInt(st.nextToken());
        for (int k = problem.size() - 1; k >= 0 ; k--) {

          if (input < problem.get(k)) {
            if (k == 0) {
              sum++;
              problem.add(k, input);
            } else {
              sum++;
            }
          } else {
            problem.add(k + 1, input);
            break;
          }
        }
      }

      result[n - 1] = sum;

    }

    for (int i = 0; i < result.length; i++) {
      System.out.printf("%d %d\n", i+1, result[i]);
    }
  }
}
