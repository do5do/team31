package tjoon._0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수리공항승_1449 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    boolean[] hole = new boolean[1001];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int temp = Integer.parseInt(st.nextToken());
      hole[temp] = true;
    }

    int count = 0;
    int i = 0;
    while (i < hole.length) {
      if (hole[i]) { // true 가 나오면 테이프 추가
        count++;
        i += (L - 1); // 테이프 길이만큼 건너뜀
      }

      i++; // false 일때도 index 는 증가
    }

    System.out.println(count);

  }

}
