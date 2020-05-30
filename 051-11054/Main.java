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
    int A[] = new int[N];
    int dp[][] = new int[2][N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(st.nextToken());
    for (int i = 0; i < 2; i++)
      Arrays.fill(dp[i], 1);

    for (int i = 1; i < N; i++)
      for (int j = 0; j < i; j++)
        if (A[i] > A[j] && dp[0][i] < dp[0][j] + 1)
          dp[0][i] = dp[0][j] + 1;

    for (int i = N - 1; i >= 0; i--)
      for (int j = N - 1; j > i; j--)
        if (A[i] > A[j] && dp[1][i] < dp[1][j] + 1)
          dp[1][i] = dp[1][j] + 1;

    int ans = 1;
    for (int i = 0; i < N; i++)
      if (ans < dp[0][i] + dp[1][i] - 1)
        ans = dp[0][i] + dp[1][i] - 1;
    log(ans);
  }
}
