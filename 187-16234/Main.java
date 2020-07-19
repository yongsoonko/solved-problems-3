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
  static int N, L, R, A[][], chk[][], sum, cnt, flag;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    A = new int[N][N];
    chk = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++)
        A[i][j] = Integer.parseInt(st.nextToken());
    }

    int ans;
    for (ans = 0; ans <= 2000; ans++) {
      flag = 0;
      for (int i = 0; i < N; i++)
        Arrays.fill(chk[i], -1);
      for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
          if (chk[i][j] == -1) {
            sum = 0;
            cnt = 0;
            dfs(i, j, (i << 6) | j);
            dfs2(i, j, sum / cnt, (i << 6 | j));
          }
      if (flag == 0)
        break;
    }
    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static void dfs(int ci, int cj, int start) {
    chk[ci][cj] = start;
    sum += A[ci][cj];
    cnt++;
    for (int d = 0; d < 4; d++) {
      int ni = ci + di[d], nj = cj + dj[d];
      if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
        int diff = Math.abs(A[ci][cj] - A[ni][nj]);
        if (L <= diff && diff <= R && chk[ni][nj] == -1) {
          flag = 1;
          dfs(ni, nj, start);
        }
      }
    }
  }

  static void dfs2(int ci, int cj, int avg, int start) {
    chk[ci][cj] = -2 - start;
    A[ci][cj] = avg;
    for (int d = 0; d < 4; d++) {
      int ni = ci + di[d], nj = cj + dj[d];
      if (ni >= 0 && ni < N && nj >= 0 && nj < N && chk[ni][nj] == start)
        dfs2(ni, nj, avg, start);
    }
  }
}
