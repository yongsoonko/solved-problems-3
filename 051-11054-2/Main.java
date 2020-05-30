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
    int dp[] = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(st.nextToken());
    Arrays.fill(dp, 1);

    for (int i = 0; i < N; i++)
      for (int j = 0; j < i; j++)
        if (A[i] > A[j] && dp[i] < dp[j] + 1)
          dp[i] = dp[j] + 1;

    for (int i = 0; i < N; i++)
      for (int j = 0; j < i; j++)
        if (A[i] < A[j] && dp[i] < dp[j] + 1)
          dp[i] = dp[j] + 1;

    int ans = 0;
    for (int i : dp)
      if (ans < i)
        ans = i;
    log(ans);
  }
}
