package jchang._2024._05._0524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class 삼각형과세변_5073_2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String str;
    while (!Objects.equals(str = br.readLine(), "0 0 0")) {
      StringTokenizer st = new StringTokenizer(str);
      int[] triangle = new int[3];
      triangle[0] = Integer.parseInt(st.nextToken());
      triangle[1] = Integer.parseInt(st.nextToken());
      triangle[2] = Integer.parseInt(st.nextToken());

      Arrays.sort(triangle);

      if (triangle[0] + triangle[1] <= triangle[2]) {
        sb.append("Invalid").append("\n");
        continue;
      }

      if (triangle[0] == triangle[1] && triangle[1] == triangle[2]) {
        sb.append("Equilateral").append("\n");
      } else if (triangle[0] == triangle[1] || triangle[0] == triangle[2]
          || triangle[1] == triangle[2]) {
        sb.append("Isosceles").append("\n");
      } else {
        sb.append("Scalene").append("\n");
      }
    }

    System.out.println(sb);
  }
}
