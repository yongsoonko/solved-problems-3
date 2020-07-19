import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, chk[][], ans;

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    N = Integer.parseInt(br.readLine());
    chk = new int[N][N];

    dfs(0);
    System.out.println(ans);

    // System.out.println("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms");
  }

  static void dfs(int ci) {
    if (ci == N)
      ans++;
    else {
      for (int j = 0; j < N; j++)
        if (chk[ci][j] == 0) {
          chkPath(ci, j, 1);
          dfs(ci + 1);
          chkPath(ci, j, -1);
        }
    }
  }

  static void chkPath(int ci, int cj, int diff) {
    for (int i = ci + 1; i < N; i++)
      chk[i][cj] += diff;

    for (int i = ci + 1, j = cj + 1; i < N && j < N; i++, j++)
      chk[i][j] += diff;

    for (int i = ci + 1, j = cj - 1; i < N && j >= 0; i++, j--)
      chk[i][j] += diff;

    chk[ci][cj] += diff;
  }
}
