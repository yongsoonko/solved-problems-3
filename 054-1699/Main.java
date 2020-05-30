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
    Arrays.fill(dp, (int) 2e9);
    dp[0] = 0;

    for (int i = 1; i * i <= N; i++)
      for (int j = i * i; j <= N; j++)
        if (dp[j] > dp[j - i * i] + 1)
          dp[j] = dp[j - i * i] + 1;

    log(dp[N]);
  }
}
