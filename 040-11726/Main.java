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
    int[] dp = new int[N + 1];
    dp[0] = dp[1] = 1;
    for (int i = 2; i <= N; i++)
      dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
    System.out.print(dp[N]);
  }
}
