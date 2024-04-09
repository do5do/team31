package doh._0409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 지름길_1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); // 고속 도로 길이

        List<Road>[] roads = new ArrayList[d + 1];
        for (int i = 1; i <= d; i++) {
            roads[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            if (end > d) { // 도착 지점이 거리보다 크면 패스
                continue;
            }

            if (end - start < length) { // 지름길이 그냥 가는 것보다 먼 경우 패스
                continue;
            }
            roads[end].add(new Road(start, end, length));
        }

        int[] distance = new int[d + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        // 1부터 d까지 하나씩 밝으면서 가야한다. (지름길이 아닌 경우도 있기 때문)
        for (int i = 1; i <= d; i++) {
            if (roads[i].isEmpty()) {
                distance[i] = distance[i - 1] + 1; // 현재 위치에 도착하려면 이전 위치에서 1만큼 온 것
                continue;
            }

            // 현재 지점(i)에 도착하는 지름길 확인
            for (Road road : roads[i]) {
                if (distance[i] > distance[road.start] + road.dist) {
                    distance[i] = Math.min(distance[road.start] + road.dist, distance[i - 1] + 1);
                }
            }
        }

        System.out.println(distance[d]);
    }

    static class Road {
        int start, end, dist;

        public Road(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }
}
