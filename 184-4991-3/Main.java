import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int i;
  int j;
  int state;

  Pos(int i, int j, int state) {
    this.i = i;
    this.j = j;
    this.state = state;
  }

  public int compareTo(Pos p) {
    return j == p.j ? j - p.j : i - p.i;
  }

  public String toString() {
    return i + " " + j + "\n";
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int T[] = new int[2048];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    String str;
    out: while ((str = br.readLine()).charAt(0) != '0') {
      StringTokenizer st = new StringTokenizer(str);
      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());
      char A[][] = new char[h][];
      boolean chk[][][] = new boolean[h][w][1024];

      Queue<Pos> Q = new LinkedList<>();
      int D[] = new int[900], cntD = 0;
      Arrays.fill(D, -1);

      for (int i = 0; i < h; i++) {
        A[i] = br.readLine().toCharArray();
        for (int j = 0; j < w; j++)
          if (A[i][j] == 'o') {
            chk[i][j][0] = true;
            Q.offer(new Pos(i, j, 0));
            A[i][j] = '.';
          } else if (A[i][j] == '*')
            D[(i << 5) | j] = cntD++;
      }

      int ans = -1, es = (1 << cntD) - 1;
      while (Q.size() > 0) {
        ans++;
        int sz = Q.size();
        while (sz-- > 0) {
          int ci = Q.peek().i, cj = Q.peek().j, cs = Q.peek().state;
          Q.poll();
          if (cs == es) {
            bw.write(ans + "\n");
            continue out;
          }

          for (int d = 0; d < 4; d++) {
            int ni = ci + di[d], nj = cj + dj[d];
            if (ni >= 0 && ni < h && nj >= 0 && nj < w) {
              if (A[ni][nj] == '.' && !chk[ni][nj][cs]) {
                chk[ni][nj][cs] = true;
                Q.offer(new Pos(ni, nj, cs));
              } else if (A[ni][nj] == '*') {
                int i = D[(ni << 5) | nj];
                int ns = cs | (1 << i);
                if (!chk[ni][nj][ns]) {
                  chk[ni][nj][ns] = true;
                  Q.offer(new Pos(ni, nj, ns));
                }
              }
            }
          }
        }
      }
      bw.write("-1\n");
    }
    bw.flush();

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
