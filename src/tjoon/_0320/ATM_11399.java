package tjoon._0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11399 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] person = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      person[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(person);

    int total = 0;
    for (int i = 1; i < n + 1; i++) {
      int sum = 0;
      for (int j = 0; j < i; j++) {
        sum += person[j];
      }
      total += sum;
    }

    System.out.println(total);

  }

}
