import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, chk[], chk2[], chk3[], ans;

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    N = Integer.parseInt(br.readLine());
    chk = new int[N];
    chk2 = new int[50];
    chk3 = new int[50];

    dfs(0);
    System.out.println(ans);

    // System.out.println("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms");
  }

  static void dfs(int ci) {
    if (ci == N)
      ans++;
    else {
      for (int j = 0; j < N; j++)
        if (chk[j] == 0 && chk2[ci + j] == 0 && chk3[ci - j + 30] == 0) {
          chkPath(ci, j, 1);
          dfs(ci + 1);
          chkPath(ci, j, -1);
        }
    }
  }

  static void chkPath(int ci, int cj, int diff) {
    chk[cj] += diff;
    chk2[ci + cj] += diff;
    chk3[ci - cj + 30] += diff;
  }
}
