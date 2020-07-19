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

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    int tc = 1;
    out: while (tc-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      char A[][] = new char[N][];
      int chk[][][][] = new int[N][M][N][M];
      Pos R = null, B = null;

      for (int i = 0; i < N; i++) {
        A[i] = br.readLine().toCharArray();
        for (int j = 0; j < M; j++) {
          if (A[i][j] == 'R') {
            R = new Pos(i, j);
            A[i][j] = '.';
          } else if (A[i][j] == 'B') {
            B = new Pos(i, j);
            A[i][j] = '.';
          }
        }
      }

      chk[R.i][R.j][B.i][B.j] = 1;
      Queue<Pos> Q = new LinkedList<>();
      Q.offer(new Pos(R.i * 20 + R.j, B.i * 20 + B.j));

      int cnt = 0;
      while (Q.size() > 0) {
        cnt++;
        int sz = Q.size();
        while (sz-- > 0) {
          int cri = Q.peek().i / 20, crj = Q.peek().i % 20;
          int cbi = Q.peek().j / 20, cbj = Q.peek().j % 20;
          Q.poll();
          for (int d = 0; d < 4; d++) {
            int nri = cri, nrj = crj, nbi = cbi, nbj = cbj;
            int outR = 0, outB = 0;
            while (A[nri + di[d]][nrj + dj[d]] != '#') {
              if (A[nri += di[d]][nrj += dj[d]] == 'O') {
                outR = 1;
                break;
              }
            }
            while (A[nbi + di[d]][nbj + dj[d]] != '#') {
              if (A[nbi += di[d]][nbj += dj[d]] == 'O') {
                outB = 1;
                break;
              }
            }
            if (outB == 1)
              continue;
            else if (outR == 1) {
              log(cnt);
              continue out;
              // return;
            } else {
              if (nri == nbi && nrj == nbj) {
                if (d == 0) {
                  if (cri < cbi)
                    nbi++;
                  else
                    nri++;
                } else if (d == 1) {
                  if (crj < cbj)
                    nrj--;
                  else
                    nbj--;
                } else if (d == 2) {
                  if (cri < cbi)
                    nri--;
                  else
                    nbi--;
                } else {
                  if (crj < cbj)
                    nbj++;
                  else
                    nrj++;
                }
              }
              if (chk[nri][nrj][nbi][nbj] == 0) {
                chk[nri][nrj][nbi][nbj] = 1;
                Q.offer(new Pos(nri * 20 + nrj, nbi * 20 + nbj));
              }
            }
          }
        }
      }
      log("-1");
    }

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
