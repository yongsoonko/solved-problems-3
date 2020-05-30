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

    StringTokenizer st = new StringTokenizer(br.readLine());
    int A[] = new int[N + 1];
    int dp[] = new int[N + 1];
    int ans = (int) -2e9;
    for (int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
      dp[i] = Math.max(dp[i - 1] + A[i], A[i]);
      if (ans < dp[i])
        ans = dp[i];
    }

    log(ans);
  }
}
