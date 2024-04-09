package tjoon._202403._0306;

import java.util.Scanner;

public class 누울자리를찾아라_1652 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int width = 0;
    int height = 0;

    int N = scanner.nextInt();
    char[][] room = new char[N][N];

    for (int i = 0; i < N; i++) {
      String input = scanner.next();
      for (int j = 0; j < N; j++) {
        room[i][j] = input.charAt(j);
      }
    }

    for (int i = 0; i < N; i++) {
      int widthCount = 0;
      int heightCount = 0;

      for (int j = 0; j < N; j++) {

        if (room[i][j] == '.') {
          widthCount++;
        }
        if (room[i][j] == 'X' || (j == N - 1)) {
          if (widthCount >= 2) {
            width++;
          }
          widthCount = 0;
        }

        if (room[j][i] == '.') {
          heightCount++;
        }
        if (room[j][i] == 'X' || (j == N - 1)) {
          if (heightCount >= 2) {
            height++;
          }
          heightCount = 0;
        }

      }
    }

    System.out.println(width + " " + height);
  }

}
