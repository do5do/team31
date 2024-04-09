package doh._03._0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings); // 정렬을 했기 때문에 dp를 안써도 될 것 같았다. 그리디!

        int cnt = 1;
        Meeting meeting = meetings[0];

        for (int i = 1; i < n; i++) {
            if (meetings[i].start >= meeting.end) {
                cnt++;
                meeting = meetings[i];
            }
        }

        System.out.println(cnt);
    }

    static class Meeting implements Comparable<Meeting> {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            int result = Integer.compare(end, o.end);
            if (result == 0) {
                result = Integer.compare(start, o.start);
            }
            return result;
        }
    }
}
