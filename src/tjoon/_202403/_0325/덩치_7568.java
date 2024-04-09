package tjoon._202403._0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 덩치_7568 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());

    List<Person> people = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());

      people.add(new Person(w, h));
    }

    for (int i = 0; i < N; i++) {
      int count = 1;
      for (int j = 0; j < N; j++) {
        if (people.get(i).height < people.get(j).height
            && people.get(i).weight < people.get(j).weight) {
          count++;
        }
      }

      System.out.print(count + " ");
    }


  }

  static class Person {

    int weight;
    int height;

    Person(int weight, int height) {
      this.weight = weight;
      this.height = height;
    }

  }

}
