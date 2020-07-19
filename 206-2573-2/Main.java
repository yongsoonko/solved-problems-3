import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, M, A[][], B[][], chk[][], cnt;
  static List<Integer> ice = new ArrayList<>();

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[N][M];
    B = new int[N][M];
    chk = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
        if (A[i][j] > 0)
          ice.add(i * 301 + j);
      }
    }

    int ans = 0;
    while (ice.size() > 0) {
      cnt = 0;
      dfs(ice.get(0) / 301, ice.get(0) % 301);

      if (cnt < ice.size()) {
        log(ans);
        return;
      }
      ans++;

      for (int curr : ice) {
        int ci = curr / 301, cj = curr % 301;
        for (int d = 0; d < 4; d++) {
          int ni = ci + di[d], nj = cj + dj[d];
          if (A[ni][nj] == 0)
            B[ci][cj]++;
        }
      }

      List<Integer> tmp = new ArrayList<>();
      for (int curr : ice) {
        int ci = curr / 301, cj = curr % 301;
        A[ci][cj] = Math.max(0, A[ci][cj] - B[ci][cj]);
        B[ci][cj] = 0;
        chk[ci][cj] = 0;
        if (A[ci][cj] > 0)
          tmp.add(ci * 301 + cj);
      }
      ice = tmp;
    }

    log(0);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static void dfs(int ci, int cj) {
    chk[ci][cj] = 1;
    cnt++;
    for (int d = 0; d < 4; d++) {
      int ni = ci + di[d], nj = cj + dj[d];
      if (A[ni][nj] > 0 && chk[ni][nj] == 0) {
        chk[ni][nj] = 1;
        dfs(ni, nj);
      }
    }
  }
}
