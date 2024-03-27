package tjoon._0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 쿠키의신체측정_20125 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[][] pan = new String[N][N];
    int[] di = {0, 0, 1, -1};
    int[] dj = {1, -1, 0, 0};

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      pan[i] = st.nextToken().split("");
    }

    // 심장 위치 찾기
    int heartX = 0;
    int heartY = 0;
    loop:
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {

        if (pan[i][j].equals("*")) {
          int star = 0;
          for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
              if (pan[ni][nj].equals("*")) {
                star++;
              }
            }
          }

          if (star == 4) {
            heartX = i;
            heartY = j;
            System.out.println((heartX + 1) + " " + (heartY + 1));
            break loop;
          }
        }
      }
    }

    int leftArm = 0;
    int rightArm = 0;
    int waist = 0;
    int leftLeg = 0;
    int rightLeg = 0;

    // 왼팔 오른팔
    for (int i = 0; i < N; i++) {
      if (pan[heartX][i].equals("*") && i < heartY) {
        leftArm++;
      } else if (pan[heartX][i].equals("*") && i > heartY) {
        rightArm++;
      } else if (i > heartY && pan[heartX][i].equals("-")) {
        break;
      }
    }

    // 허리
    int waistX = 0;
    for (int i = heartX + 1; i < N; i++) {
      if (pan[i][heartY].equals("*")) {
        waist++;
      } else {
        waistX = i;
        break;
      }
    }

    // 왼쪽 다리
    for (int i = waistX; i < N; i++) {
      if (pan[i][heartY - 1].equals("*")) {
        leftLeg++;
      } else {
        break;
      }
    }

    // 오른쪽 다리
    for (int i = waistX; i < N; i++) {
      if (pan[i][heartY + 1].equals("*")) {
        rightLeg++;
      } else {
        break;
      }
    }

    System.out.println(
        leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
  }

}
