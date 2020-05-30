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
    int T = Integer.parseInt(br.readLine());
    long dp[] = new long[101];
    dp[1] = dp[2] = dp[3] = 1;
    dp[4] = dp[5] = 2;
    for (int i = 6; i <= 100; i++)
      dp[i] = dp[i - 1] + dp[i - 5];

    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      log(dp[N] + "\n");
    }
  }
}
