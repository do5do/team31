package tjoon._0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 벌집_2292 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    if (N == 1) {
      System.out.println(1);
      System.exit(0);
    }

    int sum = 1;
    int count = 1;
    while (sum < N) {
      sum += (count * 6);
      count++;
    }

    System.out.println(count);
  }

}
