package tjoon._202403._0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 삼각형과세변_5073 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    while (true) {
      st = new StringTokenizer(br.readLine());
      int[] tri = new int[3];

      for (int i = 0; i < 3; i++) {
        tri[i] = Integer.parseInt(st.nextToken());
      }

      if (Arrays.stream(tri).sum() == 0) {
        break;
      }

      Arrays.sort(tri);

      int A = tri[0];
      int B = tri[1];
      int C = tri[2];

      if (A + B <= C) {
        System.out.println("Invalid");
      } else {
        if (A == B || B == C) {
          if (A != B || B != C) {
            System.out.println("Isosceles");
          } else {
            System.out.println("Equilateral");
          }
        } else {
          System.out.println("Scalene");
        }
      }

    }

  }

}
