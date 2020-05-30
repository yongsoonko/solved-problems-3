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

    int A[] = new int[N + 1];
    int dp[][] = new int[3][N + 1];
    for (int i = 1; i <= N; i++)
      A[i] = Integer.parseInt(br.readLine());
    dp[1][1] = A[1];

    for (int i = 2; i <= N; i++) {
      dp[1][i] = Math.max(dp[1][i - 2], dp[2][i - 2]) + A[i];
      dp[2][i] = dp[1][i - 1] + A[i];
    }

    log(Math.max(dp[1][N], dp[2][N]));
  }
}
