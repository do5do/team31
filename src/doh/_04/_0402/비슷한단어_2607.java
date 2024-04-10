package doh._04._0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비슷한단어_2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];
        String standard = br.readLine();
        int answer = 0;

        for (int i = 0; i < standard.length(); i++) {
            alphabet[standard.charAt(i) - 'A']++;
        }

        for (int i = 0; i < n - 1; i++) {
            int[] temp = alphabet.clone();
            String str = br.readLine();
            int cnt = 0; // 같은 단어

            // 길이 차이가 1을 넘어가면 볼 필요 없음
            if (Math.abs(standard.length() - str.length()) > 1) {
                continue;
            }

            for (int j = 0; j < str.length(); j++) {
                int curIdx = str.charAt(j) - 'A';

                if (temp[curIdx] > 0) {
                    cnt++;
                    temp[curIdx]--; // 중복 체크
                }
            }

            if (standard.length() == str.length()) {
                if (cnt == standard.length() || cnt == standard.length() - 1) { // 두번째 조건은 OOG와 같은 경우에 해당 됨
                    answer++;
                }
            } else if (standard.length() - 1 == str.length()) {
                if (cnt == standard.length() - 1) { // 하나 제거된 경우
                    answer++;
                }
            } else if (standard.length() + 1 == str.length()) {
                if (cnt == standard.length()) { // 하나 추가된 경우
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}

// 기준이 DOG인 경우, 추가되거나 제거되는 건 D,O,G 중에 하나가 추가되거나 제거됨을 말하는 거였다..