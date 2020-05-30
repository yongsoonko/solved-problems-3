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
    int T = Integer.parseInt(br.readLine());
    int[] dp = new int[11];
    dp[0] = 1;
    for (int i = 1; i < 11; i++) {
      if (i >= 3)
        dp[i] += dp[i - 3];
      if (i >= 2)
        dp[i] += dp[i - 2];
      dp[i] += dp[i - 1];
    }

    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine());
      bw.write(dp[n] + "\n");
    }
    bw.flush();
  }
}
