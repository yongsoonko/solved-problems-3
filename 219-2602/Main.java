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
    for (int i = 0; i < 2; i++)
      for (int j = 0; j < A[0].length; j++)
        Arrays.fill(cache[i][j], -1);

    dfs(0, 0, 0);
    dfs(1, 0, 0);
    log(ans);
    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static int dfs(int r, int curr, int cnt) {
    if (cnt == str.length)
      return 1;
    if (curr < A[0].length) {
      if (cache[r][curr][cnt] >= 0)
        return cache[r][curr][cnt];

      int res = 0;
      for (int i = curr; i < A[0].length; i++)
        if (str[cnt] == A[r][i])
          res += dfs(1 - r, i + 1, cnt + 1);
      if (cnt == 0)
        ans += res;
      return cache[r][curr][cnt] = res;
    } else
      return 0;
  }
}
