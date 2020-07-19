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
    return j == p.j ? i - p.i : j - p.j;
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
    // 0 1 2 52 -1 2
    int tc = 1;
    out: while (tc-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int A[][] = new int[101][101];
      // 1 ~ 100;

      for (int i = 1; i <= 3; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= 3; j++)
          A[i][j] = Integer.parseInt(st.nextToken());
      }

      int rCnt = 3, cCnt = 3;
      for (int time = 0; time <= 100; time++) {
        if (A[r][c] == k) {
          log(time + "\n");
          continue out;
        }
        int rMaxCnt = 0, cMaxCnt = 0;
        if (rCnt >= cCnt) {
          for (int i = 1; i <= rCnt; i++) {
            Pos cnt[] = new Pos[101];
            for (int j = 1; j <= 100; j++)
              cnt[j] = new Pos(j, (int) 1e9);
            for (int j = 1; j <= cCnt; j++) {
              if (A[i][j] == 0)
                continue;
              if (cnt[A[i][j]].j == (int) 1e9)
                cnt[A[i][j]].j = 1;
              else
                cnt[A[i][j]].j++;
            }
            Arrays.sort(cnt, 1, 101);
            // if (i == rCnt) {
            // for (int d = 1; d < 8; d++)
            // log(cnt[d]);
            // System.exit(0);
            // }
            for (int j = 1; j <= 50; j++) {
              if (cnt[j].j == (int) 1e9) {
                cMaxCnt = Math.max(cMaxCnt, j * 2 - 2);
                while (j <= 50) {
                  A[i][j * 2 - 1] = 0;
                  A[i][j * 2] = 0;
                  j++;
                }
                break;
              } else {
                A[i][j * 2 - 1] = cnt[j].i;
                A[i][j * 2] = cnt[j].j;
              }
            }
          }
          cCnt = cMaxCnt;
          // for (int i = 1; i <= rCnt; i++) {
          // for (int j = 1; j <= cCnt; j++)
          // log(A[i][j] + " ");
          // log('\n');
          // }
          // log('\n');
        } else {
          for (int i = 1; i <= cCnt; i++) {
            Pos cnt[] = new Pos[101];
            for (int j = 1; j <= 100; j++)
              cnt[j] = new Pos(j, (int) 1e9);
            for (int j = 1; j <= rCnt; j++) {
              if (A[j][i] == 0)
                continue;
              if (cnt[A[j][i]].j == (int) 1e9)
                cnt[A[j][i]].j = 1;
              else
                cnt[A[j][i]].j++;
            }
            Arrays.sort(cnt, 1, 101);
            for (int j = 1; j <= 50; j++) {
              if (cnt[j].j == (int) 1e9) {
                rMaxCnt = Math.max(rMaxCnt, j * 2 - 2);
                while (j <= 50) {
                  A[j * 2 - 1][i] = 0;
                  A[j * 2][i] = 0;
                  j++;
                }
                break;
              } else {
                A[j * 2 - 1][i] = cnt[j].i;
                A[j * 2][i] = cnt[j].j;
              }
            }
          }
          rCnt = rMaxCnt;
          // for (int i = 1; i <= rCnt; i++) {
          // for (int j = 1; j <= cCnt; j++)
          // log(A[i][j] + " ");
          // log('\n');
          // }
          // log('\n');
        }
      }
      log("-1\n");
    }

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
