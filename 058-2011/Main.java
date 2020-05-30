import java.io.*;
import java.util.*;

class Pos {
  int i, j;

  Pos(int i, int j) {
    this.i = i;
    this.j = j;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    String str = br.readLine();
    int dp[][] = new int[2][str.length()];

    if (str.charAt(0) == '0')
      log(0);
    else {
      dp[0][0] = 1;
      for (int i = 1; i < str.length(); i++) {
        if (str.charAt(i) > '0')
          dp[0][i] = (dp[0][i - 1] + dp[1][i - 1]) % 1000000;
        int num = (str.charAt(i - 1) - '0') * 10 + str.charAt(i) - '0';
        if (num >= 1 && num <= 26)
          dp[1][i] = dp[0][i - 1];
      }
      log((dp[0][str.length() - 1] + dp[1][str.length() - 1]) % 1000000);
    }
  }
}
