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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int dp[][] = new int[201][201];
    for (int i = 0; i <= N; i++)
      dp[1][i] = 1;
    for (int i = 1; i <= K; i++)
      dp[i][0] = 1;
    for (int i = 2; i <= K; i++)
      for (int j = 1; j <= N; j++)
        dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % (int) 1e9;

    log(dp[K][N]);
  }
}
