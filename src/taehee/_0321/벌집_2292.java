package taehee._0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 벌집_2292 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int count = 1;
    int num = 1;
    while (true) {
      if (N <= num) {
        break;
      }
      num += (6 * count++);
    }
    System.out.println(count);
  }
}
// 개수가 등비수열?로 늘어남
// 1->6x1->6x2->6xn-1->6xn...
