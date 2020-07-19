import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int i;
  int j;
  int k;

  Pos(int i, int j, int k) {
    this.i = i;
    this.j = j;
    this.k = k;
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
  static int di[] = {-1, 0, 1, 0, 0, 0}, dj[] = {0, 1, 0, -1, 0, 0}, dk[] = {0, 0, 0, 0, 1, -1};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    String str;

    out: while ((str = br.readLine()).charAt(0) != '0') {
      StringTokenizer st = new StringTokenizer(str);
      int L = Integer.parseInt(st.nextToken());
      int R = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());
      char A[][][] = new char[L][R][];
      int chk[][][] = new int[L][R][C];
      Queue<Pos> Q = new LinkedList<>();

      for (int k = 0; k < L; k++) {
        for (int i = 0; i < R; i++) {
          A[k][i] = br.readLine().toCharArray();
          for (int j = 0; j < C; j++)
            if (A[k][i][j] == 'S')
              Q.offer(new Pos(i, j, k));
        }
        br.readLine();
      }

      int dis = 0;
      while (Q.size() > 0) {
        dis++;
        int sz = Q.size();
        while (sz-- > 0) {
          int ci = Q.peek().i, cj = Q.peek().j, ck = Q.peek().k;
          Q.poll();
          for (int d = 0; d < 6; d++) {
            int ni = ci + di[d], nj = cj + dj[d], nk = ck + dk[d];
            if (ni >= 0 && ni < R && nj >= 0 && nj < C && nk >= 0 && nk < L) {
              if (A[nk][ni][nj] == 'E') {
                bw.write("Escaped in " + dis + " minute(s).\n");
                continue out;
              } else if (A[nk][ni][nj] == '.' && chk[nk][ni][nj] == 0) {
                chk[nk][ni][nj] = 1;
                Q.offer(new Pos(ni, nj, nk));
              }
            }
          }
        }
      }
      bw.write("Trapped!\n");
    }
    bw.flush();
    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
