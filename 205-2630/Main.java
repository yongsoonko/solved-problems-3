import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, A[][], ans[] = new int[2];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    N = Integer.parseInt(br.readLine());
    A = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++)
        A[i][j] = Integer.parseInt(st.nextToken());
    }

    dfs(0, 0, N);
    log(ans[0] + "\n" + ans[1]);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static int dfs(int si, int sj, int size) {
    if (size == 1)
      return A[si][sj];

    size /= 2;
    int cnt[] = new int[3];
    for (int i = 0; i < 2; i++)
      for (int j = 0; j < 2; j++)
        cnt[dfs(si + size * i, sj + size * j, size)]++;

    if (cnt[0] == 4) {
      if (size == N / 2)
        ans[0] = 1;
      return 0;
    } else if (cnt[1] == 4) {
      if (size == N / 2)
        ans[1] = 1;
      return 1;
    } else {
      ans[0] += cnt[0];
      ans[1] += cnt[1];
      return 2;
    }
  }
}
