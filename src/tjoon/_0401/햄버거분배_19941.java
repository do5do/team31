package tjoon._0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거분배_19941 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    char[] bench = br.readLine().toCharArray();

    int count = 0;
    loop:
    for (int i = 0; i < N; i++) {
      if (bench[i] == 'P') { // 사람이면
        for (int j = i - K; j <= i + K; j++) {
          if (j >= 0 && j < N && bench[j] == 'H') {
            bench[j] = '-'; // 햄버거 아웃
            count++;
            continue loop;
          }
        }
      }
    }

    System.out.println(count);

  }

}
