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
    int[][] dp = new int[2][10];
    Arrays.fill(dp[0], 1);

    int curr = 0, next = 1;
    for (int i = 2; i <= N; i++) {
      for (int j = 0; j <= 9; j++)
        for (int k = j; k <= 9; k++)
          dp[next][k] = (dp[next][k] + dp[curr][j]) % 10007;
      curr ^= next;
      next ^= curr;
      curr ^= next;
      Arrays.fill(dp[next], 0);
    }

    int ans = 0;
    for (int i : dp[curr])
      ans = (ans + i) % 10007;
    System.out.println(ans);
  }
}
