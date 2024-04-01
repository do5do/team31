package tjoon._0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class 영단어암기는어려워_20920 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      if (str.length() >= M) {
        map.put(str, map.getOrDefault(str, 0) + 1);
      }
    }

    List<Word> words = new ArrayList<>();
    for (Entry<String, Integer> entry : map.entrySet()) {
      words.add(new Word(entry.getKey(), entry.getValue()));
    }

    Collections.sort(words);

    StringBuilder sb = new StringBuilder();
    for (Word word : words) {
      sb.append(word.spell);
      sb.append("\n");
    }

    System.out.println(sb);

  }

  static class Word implements Comparable<Word> {

    String spell;
    int count;

    Word(String spell, int count) {
      this.spell = spell;
      this.count = count;
    }


    @Override
    public int compareTo(Word o) {
      int result = Integer.compare(o.count, this.count);

      if (result == 0) {
        result = Integer.compare(o.spell.length(), this.spell.length());
        if (result == 0) {
          result = this.spell.compareTo(o.spell);
        }

      }

      return result;
    }
  }

}
