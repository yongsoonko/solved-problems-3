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
    int n = Integer.parseInt(br.readLine());
    int[] A = new int[n];
    int[][] dp = new int[3][n];
    for (int i = 0; i < n; i++)
      A[i] = Integer.parseInt(br.readLine());

    dp[1][0] = A[0];
    for (int i = 1; i < n; i++) {
      dp[0][i] = Math.max(Math.max(dp[0][i - 1], dp[1][i - 1]), dp[2][i - 1]);
      // 반례 : 100 100 1 1 100 100 두번 연속으로 먹지 말아야 하는 경우가 있음.
      // dp[0][i] = Math.max(dp[1][i - 1], dp[2][i - 1]);
      dp[1][i] = dp[0][i - 1] + A[i];
      dp[2][i] = dp[1][i - 1] + A[i];
    }

    System.out.println(Math.max(Math.max(dp[0][n - 1], dp[1][n - 1]), dp[2][n - 1]));
  }
}
