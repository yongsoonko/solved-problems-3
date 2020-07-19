import java.io.*;
import java.util.*;

class Pos /* implements Comparable<Pos> */ {
  int s;
  int d;
  int z;

  public Pos(int s, int d, int z) {
    this.s = s;
    this.d = d;
    this.z = z;
  }

  @Override
  public String toString() {
    return "{" + " s='" + s + "'" + ", d='" + d + "'" + ", z='" + z + "'" + "}";
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 1, 0, 0}, dj[] = {0, 0, 1, -1};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    Pos A[][] = new Pos[R + 1][C + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken()) - 1;
      int z = Integer.parseInt(st.nextToken());
      A[r][c] = new Pos(s, d, z);
    }

    int ans = 0;
    for (int curr = 1; curr <= C; curr++) {
      for (int i = 1; i <= R; i++)
        if (A[i][curr] != null) {
          ans += A[i][curr].z;
          A[i][curr] = null;
          break;
        }

      Pos tmp[][] = new Pos[R + 1][C + 1];
      for (int i = 1; i <= R; i++)
        for (int j = 1; j <= C; j++)
          if (A[i][j] != null) {
            int cycle = A[i][j].d <= 1 ? (R - 1) * 2 : (C - 1) * 2;
            int tmpS = A[i][j].s % cycle;
            int ci = i, cj = j;
            for (int k = 0; k < tmpS; k++) {
              ci += di[A[i][j].d];
              cj += dj[A[i][j].d];
              if (ci <= 0) {
                ci = 2;
                A[i][j].d = 1;
              } else if (ci > R) {
                ci = R - 1;
                A[i][j].d = 0;
              } else if (cj <= 0) {
                cj = 2;
                A[i][j].d = 2;
              } else if (cj > C) {
                cj = C - 1;
                A[i][j].d = 3;
              }
            }
            if (tmp[ci][cj] == null || tmp[ci][cj].z < A[i][j].z)
              tmp[ci][cj] = new Pos(A[i][j].s, A[i][j].d, A[i][j].z);
            A[i][j] = null;
            // log(ci + " " + cj + " ");
            // log(tmp[ci][cj] + "\n");
          }
      A = tmp;
    }
    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
