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
    int dp[] = new int[N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++)
      A[i] = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= N; i++)
      for (int j = i; j <= N; j++)
        if (dp[j] < dp[j - i] + A[i])
          dp[j] = dp[j - i] + A[i];

    log(dp[N]);
  }
}
