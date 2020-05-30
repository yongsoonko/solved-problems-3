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
    int[][] A = new int[2][100001];
    int[][] dp = new int[3][100001];
    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine());
      for (int[] a : dp)
        Arrays.fill(a, 1, n + 1, 0);

      for (int i = 0; i < 2; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= n; j++)
          A[i][j] = Integer.parseInt(st.nextToken());
      }

      for (int i = 1; i <= n; i++) {
        dp[0][i] = Math.max(dp[1][i - 1], dp[2][i - 1]) + A[0][i];
        dp[1][i] = Math.max(dp[0][i - 1], dp[2][i - 1]) + A[1][i];
        dp[2][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
      }

      System.out.println(Math.max(dp[0][n], dp[1][n]));
    }
  }
}
