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

    dp[0] = A[0];
    int ans = A[0];
    for (int i = 1; i < N; i++) {
      int max = 0;
      for (int j = i - 1; j >= 0; j--)
        if (A[i] > A[j] && max < dp[j])
          max = dp[j];
      dp[i] = max + A[i];
      ans = Math.max(ans, dp[i]);
    }

    log(ans);
  }
}
