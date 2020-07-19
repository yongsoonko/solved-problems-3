import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static char str[], A[][] = new char[2][];
  static int cache[][][], ans;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    str = br.readLine().toCharArray();
    A[0] = br.readLine().toCharArray();
    A[1] = br.readLine().toCharArray();

    cache = new int[2][A[0].length][str.length];
    for (int i = 0; i < A[0].length; i++) {
      Arrays.fill(cache[0][i], -1);
      Arrays.fill(cache[1][i], -1);
    }

    ans += dfs(0, 0, 0);
    ans += dfs(1, 0, 0);
    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static int dfs(int ci, int cj, int state) {
    if (state == str.length)
      return 1;
    else if (cj < A[0].length) {
      if (cache[ci][cj][state] >= 0)
        return cache[ci][cj][state];

      int ni = 1 - ci, res = 0;
      for (int j = cj; j < A[0].length; j++)
        if (A[ci][j] == str[state])
          res += dfs(ni, j + 1, state + 1);

      return cache[ci][cj][state] = res;
    } else
      return 0;
  }
}
