package doh._03._0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2816 디지털 티비
 */
public class DigitalTV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 채널의 수
        String[] channels = new String[n];

        for (int i = 0; i < n; i++) {
            channels[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < channels.length; i++) {
            if (channels[i].equals("KBS1")) { // KBS1을 첫번째로
                String kbs;
                for (int j = i; j > 0; j--) {
                    kbs = channels[j];
                    channels[j] = channels[j - 1];
                    channels[j - 1] = kbs;
                    sb.append(4); // 채널 위치 이동 - up
                }
                break;
            } else {
                sb.append(1); // 방향 이동 - down
            }
        }

        if (channels[1].equals("KBS2")) { // 밑에서 체크해주면 1이 추가 됨
            System.out.println(sb);
            System.exit(0);
        }

        for (int i = 0; i < channels.length; i++) {
            if (channels[i].equals("KBS2")) { // KBS2를 첫번째로
                String kbs;
                for (int j = i; j > 1; j--) {
                    kbs = channels[j];
                    channels[j] = channels[j - 1];
                    channels[j - 1] = kbs;
                    sb.append(4); // 채널 위치 이동 - up
                }
                break;
            } else {
                sb.append(1); // 방향 이동 - down
            }
        }

        System.out.println(sb);
    }
}

/*
- 그리디인가?
 */