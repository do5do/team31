package tjoon._202403._0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌게임_9655 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    boolean flag = false;
    while (N > 0) {

      if (N == 3 || N == 1) {
        N = 0;
        if (!flag) {
          System.out.println("SK");
        } else {
          System.out.println("CY");
        }

      } else if (N == 2) {
        N = 0;
        if (!flag) {
          System.out.println("CY");
        } else {
          System.out.println("SK");
        }

      } else {
        N -= 3;
        flag = !flag;
      }

    }


  }

}
