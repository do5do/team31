package jchang._2024._06._0605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 영단어암기는괴로워_20920_2 {
  // 1. 자주 나오는 단어 앞에 배치
  // 2. 단어의 길이가 길수록 앞에 배치
  // 3. 알파벳 사전 순으로 배치
  // M 이상의 단어만 외움  --> 정렬 문제
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 단어 출현 횟수를 세기 위해 map으로 입력을 받으며 단어 출현 횟수를 센다.(m 미만 길이 단어 탈락)
    // 나중에 정렬을 편하게 하기 위해 map의 value 타입을 Word 클래스(단어, 출현빈도)로 만들어 사용함.
    Map<String, Word> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      if (str.length() >= m) {
        map.computeIfAbsent(str, v -> new Word(str)).count++;
      }
    }

    // map의 value를 정렬 기준에 맞게 정렬한다.
    List<Word> values = map.values().stream().sorted(new Comparator<Word>() {
      @Override
      public int compare(Word o1, Word o2) {
        if (o1.count == o2.count) {
          if (o1.word.length() == o2.word.length()) {
            return o1.word.compareTo(o2.word);
          }
          return Integer.compare(o2.word.length(), o1.word.length());
        }
        return Integer.compare(o2.count, o1.count);
      }
    }).collect(Collectors.toList());

    StringBuilder sb = new StringBuilder();
    for (Word word : values) {
      sb.append(word.word).append("\n");
    }
    System.out.println(sb);
  }

  public static class Word{
    String word;
    int count;
    public Word(String word) {
      this.word = word;
    }
  }
}
