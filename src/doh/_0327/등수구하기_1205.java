package doh._0327;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등수구하기_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken()); // 총 랭킹 수

        if (n == 0) {
            System.out.println(1);
            System.exit(0);
        }

        st = new StringTokenizer(br.readLine());
        Point[] points = new Point[p];

        // Arrays.sort(points);

        for (int i = 0; i < p; i++) {
            if (st.hasMoreTokens()) {
                int rank = Integer.parseInt(st.nextToken());
                points[i] = new Point(rank);
            } else {
                points[i] = new Point(0);
            }
        }

        // 랭크 진입 불가
        if (n == p && points[n - 1].score >= score) {
            System.out.println(-1);
            System.exit(0);
        }

        points[0].rank = 1;
        if (score >= points[0].score) { // 최상위
            System.out.println(1);
            System.exit(0);
        }

        if (score < points[n - 1].score) { // 최하위
            points[n] = new Point(score);
        }

        for (int i = 1; i < p; i++) {
            Point prev = points[i - 1];
            Point cur = points[i];

            if (cur.score < prev.score) {
                cur.rank = i + 1;
            } else {
                cur.rank = prev.rank;
            }

            if (cur.score <= score) {
                System.out.println(cur.rank);
                break;
            }
        }
    }

    static class Point {
        int score, rank;

        public Point(int score) {
            this.score = score;
        }
    }

//    static class Point implements Comparable<Point> {
//        int score, rank;
//
//        public Point(int score) {
//            this.score = score;
//        }
//
//        public int compareTo(Point o) {
//            return Integer.compare(o.score, score);
//        }
//    }
}

// 정렬하면 틀린다.. 25%