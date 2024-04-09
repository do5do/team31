package tjoon._202403._0314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일곱난쟁이_2309 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] dwarf = new int[9];
    int sum = 0;

    for (int i = 0; i < 9; i++) {
      dwarf[i] = Integer.parseInt(br.readLine());
      sum += dwarf[i];
    }

    int first = 0;
    int second = 0;

    firstLoop:
    for (int i = 0; i < 9; i++) {
      for (int j = i + 1; j < 9; j++) {
        if (sum - (dwarf[i] + dwarf[j]) == 100) {
          first = dwarf[i];
          second = dwarf[j];
          break firstLoop;
        }
      }
    }

    Arrays.sort(dwarf);
    for (int i = 0; i < 9; i++) {
      if (dwarf[i] != first && dwarf[i] != second) {
        System.out.println(dwarf[i]);
      }
    }


  }

}
