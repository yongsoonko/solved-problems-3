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
    int N = Integer.parseInt(br.readLine());
    int dp[] = new int[N + 1];
    dp[0] = 1;

    for (int i = 2; i <= N; i += 2) {
      dp[i] = dp[i - 2] * 3;
      for (int j = 4; j <= i; j += 2)
        dp[i] += dp[i - j] * 2;
    }
    log(dp[N]);
  }
}
