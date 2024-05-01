package tjoon._202404._0429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비슷한단어_2179 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] strArr = new String[n];
        for (int i = 0; i < n; i++) {
            strArr[i] = br.readLine();
        }

        int max = Integer.MIN_VALUE;
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < strArr.length - 1; i++) {
            for (int j = i + 1; j < strArr.length; j++) {
                int count = 0;

                int size = Math.min(strArr[i].length(), strArr[j].length());
                for (int k = 0; k < size; k++) {
                    if (strArr[i].charAt(k) == strArr[j].charAt(k)) {
                        count++;
                    } else {
                        break;
                    }
                }

                if (count > max) {
                    idx1 = i;
                    idx2 = j;
                    max = count;
                }
            }
        }

        System.out.println(strArr[idx1]);
        System.out.println(strArr[idx2]);

    }
}
