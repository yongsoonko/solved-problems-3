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
  static int N, A[][], chk[], B[], C[], ans = (int) 1e9;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    N = Integer.parseInt(br.readLine());
    A = new int[N][N];
    chk = new int[N];
    B = new int[N / 2];
    C = new int[N / 2];

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
    if (cnt == N / 2) {
      int p = 0, q = 0;
      for (int i = 0; i < N; i++) {
        if (chk[i] == 1)
          B[p++] = i;
        else
          C[q++] = i;
      }

      int sumB = 0, sumC = 0;
      for (int i = N / 2 - 1; i >= 0; i--)
        for (int j = N / 2 - 1; j >= 0; j--)
          if (i != j)
            sumB += A[B[i]][B[j]];
      for (int i = N / 2 - 1; i >= 0; i--)
        for (int j = N / 2 - 1; j >= 0; j--)
          if (i != j)
            sumC += A[C[i]][C[j]];
      int diff = Math.abs(sumB - sumC);
      if (ans > diff)
        ans = diff;
    } else if (curr < N) {
      chk[curr] = 1;
      dfs(curr + 1, cnt + 1);
      chk[curr] = 0;
      dfs(curr + 1, cnt);
    }
  }
}
