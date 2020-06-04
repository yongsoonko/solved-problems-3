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
  static int N, W[][], chk[], ans = (int) 1e9;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    W = new int[N][N];
    chk = new int[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++)
        W[i][j] = Integer.parseInt(st.nextToken());
    }

    chk[0] = 1;
    dfs(0, 0, 0);
    log(ans);
  }

  static void dfs(int curr, int cnt, int sum) {
    if (cnt == N - 1 && W[curr][0] > 0)
      ans = Math.min(ans, sum + W[curr][0]);
    else
      for (int next = 0; next < N; next++)
        if (W[curr][next] > 0 && chk[next] == 0) {
          chk[next] = 1;
          dfs(next, cnt + 1, sum + W[curr][next]);
          chk[next] = 0;
        }
  }
}
