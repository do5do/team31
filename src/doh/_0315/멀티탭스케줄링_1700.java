package doh._0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 멀티탭스케줄링_1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 구멍 수
        int k = Integer.parseInt(st.nextToken());

        int[] page = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            page[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> usedSet = new HashSet<>(); // 사용중인 리스트
        int cnt = 0;

        for (int i = 0; i < k; i++)  {
            if (usedSet.contains(page[i]) && usedSet.size() >= n) {
                continue;
            }

            if (usedSet.size() < n) {
                usedSet.add(page[i]);
                continue;
            }

            // replacement
            List<Integer> list = new ArrayList<>(); // 미래에 재사용 되는 리스트
            for (int j = i + 1; j < k; j++) {
                if (usedSet.contains(page[j]) && !list.contains(page[j])) { // 중복 제거해야함
                    list.add(page[j]);
                }
            }

            // 현재 사용중인게 모두 재사용 될 때
            if (usedSet.size() == list.size()) {
                // 가장 마지막에 사용될 요소 제거
                usedSet.remove(list.get(list.size() - 1));
            } else {
                int remove = 0;
                for (int used : usedSet) {
                    remove = used;

                    if (!list.contains(remove)) { // 재사용되지 않는 요소 제거
                        break;
                    }
                }
                usedSet.remove(remove);
            }

            cnt++; // 교체
            usedSet.add(page[i]);
        }

        System.out.println(cnt);
    }
}
