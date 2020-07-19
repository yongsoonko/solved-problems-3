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
  static int N, M, A[][], cache[][], ans;
  static char D[] = new char[128];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    D['U'] = 0;
    D['R'] = 1;
    D['D'] = 2;
    D['L'] = 3;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[N + 1][M + 1];
    cache = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      String str = br.readLine();
      for (int j = 1; j <= M; j++)
        A[i][j] = D[str.charAt(j - 1)];
    }

    for (int i = 1; i <= N; i++)
      for (int j = 1; j <= M; j++) {
        if (cache[i][j] == 0) {
          cache[i][j] = i * 510 + j;
          dfs(i, j, cache[i][j]);
        }
        if (cache[i][j] == -1)
          ans++;
      }

    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  // -1 : out
  // -2 : cycle
  static int dfs(int ci, int cj, int start) {
    if (cache[ci][cj] == -1 || cache[ci][cj] == -2)
      return cache[ci][cj];
    cache[ci][cj] = start;
    int ni = ci + di[A[ci][cj]], nj = cj + dj[A[ci][cj]];
    if (ni < 1 || ni > N || nj < 1 || nj > M)
      return cache[ci][cj] = -1;
    if (cache[ni][nj] == start)
      return cache[ci][cj] = -2;
    return cache[ci][cj] = dfs(ni, nj, start);
  }
}
