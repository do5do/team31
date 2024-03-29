package doh._0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 영단어암기는괴로워_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Word> words = new ArrayList<>();
        Map<String, Word> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            if (map.containsKey(word)) {
                map.get(word).count++;
            } else {
                map.put(word, new Word(word, word.length()));
                words.add(map.get(word));
            }
        }

        Collections.sort(words);

        StringBuilder sb = new StringBuilder();
        for (Word w : words) {
            if (w.length >= m) {
                sb.append(w.str).append("\n");
            }
        }

        System.out.println(sb);
    }

    static class Word implements Comparable<Word> {
        String str;
        int count;
        int length;

        public Word(String str, int length) {
            this.str = str;
            this.length = length;
        }

        public int compareTo(Word o) {
            int result = Integer.compare(o.count, count);
            if (result == 0) {
                result = Integer.compare(o.length, length);
                if (result == 0) {
                    result = str.compareTo(o.str);
                }
            }
            return result;
        }
    }
}
