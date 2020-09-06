import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, M, A[][], chk[][], ans, secondPos;

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[N][M];
    chk = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++)
        A[i][j] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++)
      for (int j = 0; j < M; j++) {
        chk[i][j] = 1;
        dfs(i, j, 1, A[i][j]);
        chk[i][j] = 0;
      }

    System.out.println(ans);

    // System.out.println("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms");
  }

  static void dfs(int ci, int cj, int dth, int sum) {
    if (dth == 4) {
      if (ans < sum)
        ans = sum;
    } else {
      for (int d = 0; d < 4; d++) {
        int ni = ci + di[d], nj = cj + dj[d];
        if (ni >= 0 && ni < N && nj >= 0 && nj < M && chk[ni][nj] == 0) {
          chk[ni][nj] = 1;
          if (dth == 1)
            secondPos = ni * 1000 + nj;
          dfs(ni, nj, dth + 1, sum + A[ni][nj]);
          chk[ni][nj] = 0;
        }
      }
      if (dth == 3) {
        int si = secondPos / 1000, sj = secondPos % 1000;
        for (int d = 0; d < 4; d++) {
          int ni = si + di[d], nj = sj + dj[d];
          if (ni >= 0 && ni < N && nj >= 0 && nj < M && chk[ni][nj] == 0) {
            chk[ni][nj] = 1;
            dfs(ni, nj, dth + 1, sum + A[ni][nj]);
            chk[ni][nj] = 0;
          }
        }
      }
    }
  }
}
