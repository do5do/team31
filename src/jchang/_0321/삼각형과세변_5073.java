package jchang._0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 삼각형과세변_5073 {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[3];

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < 3; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      if (Arrays.stream(arr).sum() == 0) {
        break;
      }

      Arrays.sort(arr);
      if (arr[0] + arr[1] <= arr[2]) {
        System.out.println("Invalid");
        continue;
      }


      if (arr[0] == arr[2]) {
        System.out.println("Equilateral");
      } else if (arr[0] == arr[1] || arr[1] == arr[2]) {
        System.out.println("Isosceles");
      } else {
        System.out.println("Scalene");
      }

    }

  }

}
