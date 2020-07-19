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
  static int N, M, A[][], R[][], outOrCycle[][], cnt[][], ans;
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
    R = new int[N + 1][M + 1];
    outOrCycle = new int[N + 1][M + 1];
    cnt = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      Arrays.fill(R[i], 1, M + 1, -1);
      Arrays.fill(cnt[i], 1, M + 1, 1);
      String str = br.readLine();
      for (int j = 1; j <= M; j++)
        A[i][j] = D[str.charAt(j - 1)];
    }

    for (int i = 1; i <= N; i++)
      for (int j = 1; j <= M; j++) {
        int ni = i + di[A[i][j]], nj = j + dj[A[i][j]];
        int p = find(i * 510 + j), q = find(ni * 510 + nj);
        if (p == q)
          outOrCycle[p / 510][p % 510] = 1;
        else if (q == -1)
          outOrCycle[p / 510][p % 510] = 2;
        else
          merge(p, q);
      }

    for (int i = 1; i <= N; i++)
      for (int j = 1; j <= M; j++)
        if (R[i][j] == -1 && outOrCycle[i][j] == 2)
          ans += cnt[i][j];

    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static int find(int x) {
    int xi = x / 510, xj = x % 510;
    if (xi < 1 || xi > N || xj < 1 || xj > M)
      return -1;
    if (R[xi][xj] == -1)
      return x;
    return R[xi][xj] = find(R[xi][xj]);
  }

  static void merge(int x, int y) {
    x = find(x);
    y = find(y);
    int xi = x / 510, xj = x % 510;
    int yi = y / 510, yj = y % 510;
    if (xi * 510 + xj != yi * 510 + yj) {
      R[yi][yj] = xi * 510 + xj;
      outOrCycle[xi][xj] = outOrCycle[yi][yj];
      cnt[xi][xj] += cnt[yi][yj];
    }
  }
}
