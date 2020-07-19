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
  static int N, A[][];
  static boolean chk[][];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    N = Integer.parseInt(br.readLine());
    A = new int[N][N];

    int min = 200, max = 0;
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
        if (min > A[i][j])
          min = A[i][j];
        if (max < A[i][j])
          max = A[i][j];
      }
    }

    int ans = 1;
    for (int h = min; h < max; h++) {
      int cnt = 0;
      chk = new boolean[N][N];
      for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
          if (A[i][j] > h && !chk[i][j]) {
            dfs(i, j, h);
            cnt++;
          }
      if (ans < cnt)
        ans = cnt;
    }
    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static void dfs(int ci, int cj, int h) {
    chk[ci][cj] = true;
    for (int d = 0; d < 4; d++) {
      int ni = ci + di[d], nj = cj + dj[d];
      if (ni >= 0 && ni < N && nj >= 0 && nj < N && A[ni][nj] > h && !chk[ni][nj])
        dfs(ni, nj, h);
    }
  }
}
