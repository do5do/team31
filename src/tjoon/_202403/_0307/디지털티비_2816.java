package tjoon._202403._0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 디지털티비_2816 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int channelNum = Integer.parseInt(br.readLine());

    String[] channel = new String[channelNum];

    for (int i = 0; i < channelNum; i++) {
      channel[i] = br.readLine();
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < channelNum; i++) {
      if (channel[i].equals("KBS1")) {
        String temp = "";
        for (int j = i; j > 0; j--) {
          temp = channel[j];
          channel[j] = channel[j - 1];
          channel[j - 1] = temp;
          sb.append(4);
        }
        break;
      } else {
        sb.append(1);
      }
    }

    if (channel[1].equals("KBS2")) {
      System.out.println(sb);
      System.exit(0);
    }

    for (int i = 0; i < channelNum; i++) {
      if (channel[i].equals("KBS2")) {
        String temp = "";
        for (int j = i; j > 1; j--) {
          temp = channel[j];
          channel[j] = channel[j - 1];
          channel[j - 1] = temp;
          sb.append(4);
        }
        break;
      } else {
        sb.append(1);
      }
    }

    System.out.println(sb);

  }

}
