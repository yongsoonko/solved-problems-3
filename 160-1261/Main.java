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
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int A[][] = new int[N][M];
    int dis[][] = new int[N][M];
    int chk[][] = new int[N][M];
    int J[] = new int[1];
    for (int i = 0; i < N; i++) {
      Arrays.fill(dis[i], (int) 1e9);
      String str = br.readLine();
      for (int j = 0; j < M; j++)
        A[i][j] = str.charAt(j) - '0';
    }

    int sz = 1;
    J[0] = 0;
    dis[0][0] = 0;
    for (int i = N * M; i > 0; i--) {
      int nJ[] = new int[N * M], nSz = 0, minDis = (int) 1e9, mi = 0, mj = 0;
      for (int j = 0; j < sz; j++) {
        int ci = J[j] / 101, cj = J[j] % 101;
        if (minDis > dis[ci][cj]) {
          if (minDis < (int) 1e9)
            nJ[nSz++] = mi * 101 + mj;
          minDis = dis[ci][cj];
          mi = ci;
          mj = cj;
        } else
          nJ[nSz++] = J[j];
      }

      for (int d = 0; d < 4; d++) {
        int ni = mi + di[d], nj = mj + dj[d];
        if (ni >= 0 && ni < N && nj >= 0 && nj < M && chk[ni][nj] == 0
            && dis[ni][nj] > dis[mi][mj] + A[ni][nj]) {
          if (dis[ni][nj] == (int) 1e9)
            nJ[nSz++] = ni * 101 + nj;
          dis[ni][nj] = dis[mi][mj] + A[ni][nj];
        }
      }

      J = nJ;
      sz = nSz;
      chk[mi][mj] = 1;
    }

    // for (int[] a : dis) {
    // for (int i : a)
    // log(i + " ");
    // log('\n');
    // }
    log(dis[N - 1][M - 1]);

  }
}
