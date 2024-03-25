package tjoon._0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 줄세우기_10431 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int n = 0;
    int[] arr = new int[20];
    int sum = 0;

    for (int t = 0; t < T; t++) {

      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());

      for (int i = 0; i < arr.length; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      sum = 0;
      for (int i = 1; i < arr.length; i++) {
        for (int j = 0; j < i; j++) {
          if (arr[i] < arr[j]) {
            sum++;
          }
        }
      }

      System.out.println(n + " " + sum);

    }

  }

}