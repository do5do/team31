package doh._07._0725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 보석도둑_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2]; // 보석
        int[] bags = new int[k]; // 가방 무게

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            arr[i][0] = weight;
            arr[i][1] = price;
        }

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 보석 정렬 (무게 오름차순, 가격 내림차순)
        Arrays.sort(arr, Comparator.comparing((int[] o) -> o[0])
                .thenComparing(o -> o[1], Comparator.reverseOrder()));

        Arrays.sort(bags);

        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 가격 내림차순
        int idx = 0;

        for (int bag : bags) {
            while (idx < n && bag >= arr[idx][0]) {
                pq.offer(arr[idx][1]);
                idx++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}
