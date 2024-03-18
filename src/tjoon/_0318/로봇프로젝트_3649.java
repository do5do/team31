package tjoon._0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로봇프로젝트_3649 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String temp = null;

    while ((temp = br.readLine()) != null) {

      int hole = Integer.parseInt(temp) * 10000000;
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < arr.length; i++) {
        arr[i] = Integer.parseInt(br.readLine());
      }

      Arrays.sort(arr);

      int p1 = 0;
      int p2 = n - 1;
      boolean flag = false;

      while (p1 < p2) {
        int sum = arr[p1] + arr[p2];

        if (sum == hole) {
          System.out.println("yes " + arr[p1] + " " + arr[p2]);
          flag = true;
          break;
        } else if (sum < hole) {
          p1++;
        } else {
          p2--;
        }
      }

      if (!flag) {
        System.out.println("danger");
      }

    }
  }


}
