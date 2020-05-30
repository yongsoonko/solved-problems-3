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

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    long[][] dp = new long[91][2];
    dp[1][1] = 1;

    for (int i = 2; i <= N; i++) {
      dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
      dp[i][1] = dp[i - 1][0];
    }

    System.out.println(dp[N][0] + dp[N][1]);
  }
}
