package doh._03._0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 덩치_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Person[] people = new Person[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int tall = Integer.parseInt(st.nextToken());

            people[i] = new Person(i, weight, tall);
        }

        Arrays.sort(people);

        int[] answer = new int[n];
        people[0].rank = 1;
        answer[people[0].idx] = 1;

        for (int i = 1; i < n; i++) {
            int cnt = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (people[i].weight < people[j].weight && people[i].tall < people[j].tall) {
                    cnt++; // 현재 i보다 큰 덩치가 몇명인지 카운트
                }
            }

            if (cnt == 0) {
                people[i].rank = 1;
            } else {
                people[i].rank = cnt + 1;
            }

            answer[people[i].idx] = people[i].rank;
        }

        StringBuilder sb = new StringBuilder();
        for (int a : answer) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }

    static class Person implements Comparable<Person> {
        int idx;
        int weight, tall;
        int rank;

        public Person(int idx, int weight, int tall) {
            this.idx = idx;
            this.weight = weight;
            this.tall = tall;
        }

        public int compareTo(Person o) {
            int result = Integer.compare(o.weight, weight);
            if (result == 0) {
                result = Integer.compare(o.tall, tall);
            }
            return result;
        }
    }
}
