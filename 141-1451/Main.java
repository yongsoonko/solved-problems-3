import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int i;
  int j;

  Pos(int i, int j) {
    this.i = i;
    this.j = j;
  }

  public int compareTo(Pos p) {
    return i == p.i ? j - p.j : i - p.i;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int S[][];
  static long ans;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int A[][] = new int[N + 1][M + 1];
    for (int i = 1; i <= N; i++) {
      String str = br.readLine();
      for (int j = 1; j <= M; j++)
        A[i][j] = str.charAt(j - 1) - '0';
    }

    S = new int[N + 1][M + 1];
    for (int i = 1; i <= N; i++)
      for (int j = 1; j <= M; j++)
        S[i][j] = A[i][j] + S[i - 1][j] + S[i][j - 1] - S[i - 1][j - 1];

    dfs(0, 0, N, M, 1, 0);
    log(ans);
  }

  static void dfs(int si, int sj, int ei, int ej, long mul, int cnt) {
    int sum = S[ei][ej] - S[si][ej] - S[ei][sj] + S[si][sj];
    if (cnt == 2) {
      ans = Math.max(ans, mul * sum);
      return;
    }

    for (int i = si + 1; i < ei; i++) {
      int sum2 = S[i][ej] - S[si][ej] - S[i][sj] + S[si][sj];
      dfs(si, sj, i, ej, (sum - sum2) * mul, cnt + 1);
      dfs(i, sj, ei, ej, sum2 * mul, cnt + 1);
    }
    for (int j = sj + 1; j < ej; j++) {
      int sum2 = S[ei][j] - S[si][j] - S[ei][sj] + S[si][sj];
      dfs(si, sj, ei, j, (sum - sum2) * mul, cnt + 1);
      dfs(si, j, ei, ej, sum2 * mul, cnt + 1);
    }
  }
}
