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

  public String toString() {
    return i + " " + j + "\n";
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, A[][], chk[], ans = (int) 1e9, sum[] = new int[2];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    N = Integer.parseInt(br.readLine());
    A = new int[N][N];
    chk = new int[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++)
        A[i][j] = Integer.parseInt(st.nextToken());
    }

    chk[0] = 1;
    dfs(1, 1);
    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static void dfs(int curr, int cnt) {
    if (ans == 0)
      return;
    if (cnt == N / 2) {
      sum[0] = sum[1] = 0;
      for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
          for (int k = 0; k < 2; k++)
            if (i != j && chk[i] == k && chk[j] == k)
              sum[k] += A[i][j];
      ans = Math.min(ans, Math.abs(sum[0] - sum[1]));
    } else if (curr < N) {
      chk[curr] = 1;
      dfs(curr + 1, cnt + 1);
      chk[curr] = 0;
      dfs(curr + 1, cnt);
    }
  }
}
