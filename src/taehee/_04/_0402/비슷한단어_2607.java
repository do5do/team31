package taehee._04._0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 비슷한단어_2607 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String word = br.readLine();
    char[] wordArray = word.toCharArray();
    char[] sortedWordArray = Arrays.copyOf(wordArray, wordArray.length);
    Arrays.sort(sortedWordArray);

    int count = 0;
    List<String> sameWords = new ArrayList<>(List.of(word));

    for (int i = 0; i < n - 1; i++) {
      String input = br.readLine();
      char[] inputArray = input.toCharArray();
      char[] sortedArray = Arrays.copyOf(inputArray, inputArray.length);
      Arrays.sort(sortedArray);

      if (Arrays.equals(sortedWordArray, sortedArray)) {
        count++;
        sameWords.add(input);
      }

      if (input.length() == word.length()) {
        continue;
      }

      loop:
      for (String same : sameWords) {
        int diff = Math.abs(input.length() - same.length());

        if (diff > 1) {
          continue;
        }

        String longWord = input.length() > same.length() ? input : same;
        String shortWord = input.length() > same.length() ? same : input;

        StringBuilder sb = new StringBuilder(longWord);
        for (int j = 0; j < longWord.length(); j++) {
          char ch = sb.charAt(j);
          sb.deleteCharAt(j);
          if (sb.toString().contains(shortWord)) {
            count++;
            break loop;
          }
          sb.insert(j, ch);
        }
      }
    }

    System.out.println(count);
  }
}

//2
//ABCD
//    BCDE
//
//// 정답: 1
//
//2
//AABB
//    AAABC
//
//// 정답: 0