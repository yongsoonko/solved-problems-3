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
  static int A[][], chk[], ans;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    A = new int[5][5];
    chk = new int[1000000];

    for (int i = 0; i < 5; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++)
        A[i][j] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < 5; i++)
      for (int j = 0; j < 5; j++)
        dfs(i, j, 0, A[i][j]);
    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static void dfs(int ci, int cj, int L, int sum) {
    if (L == 5) {
      if (chk[sum] == 0) {
        chk[sum] = 1;
        ans++;
      }
    } else
      for (int d = 0; d < 4; d++) {
        int ni = ci + di[d], nj = cj + dj[d];
        if (ni >= 0 && ni < 5 && nj >= 0 && nj < 5)
          dfs(ni, nj, L + 1, sum * 10 + A[ni][nj]);
      }
  }
}
