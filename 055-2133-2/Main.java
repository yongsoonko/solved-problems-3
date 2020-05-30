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
    // dp[0] 제일 마지막 블록 : 三
    // dp[1] 제일 마지막 블록 : ㅠ
    // dp[2] 제일 마지막 블록 : ㅛ
    int dp[][] = new int[3][31];
    dp[0][2] = dp[1][2] = dp[2][2] = 1;

    for (int i = 4; i <= N; i += 2) {
      dp[0][i] = dp[0][i - 2] + dp[1][i - 2] + dp[2][i - 2];
      dp[1][i] = dp[0][i - 2] + dp[1][i - 2] + dp[2][i - 2] + dp[1][i - 2];
      dp[2][i] = dp[0][i - 2] + dp[1][i - 2] + dp[2][i - 2] + dp[2][i - 2];
    }
    log(dp[0][N] + dp[1][N] + dp[2][N]);
  }
}
