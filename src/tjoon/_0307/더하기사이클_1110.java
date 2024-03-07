package tjoon._0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 더하기사이클_1110 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int origin = Integer.parseInt(br.readLine());
    int num = origin;
    int cycle = 0;

    while (true) {
      int front = num / 10;
      int back = num % 10;

      num = back * 10 + (front + back) % 10;

      cycle++;

      if (num == origin) {
        break;
      }
    }

    System.out.println(cycle);
  }

}
