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
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int Hx = Integer.parseInt(st.nextToken());
    int Hy = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int Ex = Integer.parseInt(st.nextToken());
    int Ey = Integer.parseInt(st.nextToken());
    int A[][] = new int[N + 1][M + 1];
    int chk[][][] = new int[N + 1][M + 1][2];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= M; j++)
        A[i][j] = Integer.parseInt(st.nextToken());
    }

    chk[Hx][Hy][A[Hx][Hy]] = 1;
    Queue<Pos> Q = new LinkedList<>();
    Q.offer(new Pos(Hx, Hy, A[Hx][Hy]));

    int ans = 0;
    while (Q.size() > 0) {
      if (chk[Ex][Ey][0] == 1 || chk[Ex][Ey][1] == 1) {
        log(ans);
        System.exit(0);
      }
      ans++;
      int sz = Q.size();
      while (sz-- > 0) {
        int ci = Q.peek().i, cj = Q.peek().j, ck = Q.peek().k;
        Q.poll();
        for (int d = 0; d < 4; d++) {
          int ni = ci + di[d], nj = cj + dj[d];
          if (ni >= 1 && ni <= N && nj >= 1 && nj <= M) {
            if (ck == 0 && chk[ni][nj][A[ni][nj]] == 0) {
              chk[ni][nj][A[ni][nj]] = 1;
              Q.offer(new Pos(ni, nj, A[ni][nj]));
            } else if (ck == 1 && A[ni][nj] == 0 && chk[ni][nj][1] == 0) {
              chk[ni][nj][1] = 1;
              Q.offer(new Pos(ni, nj, 1));
            }
          }
        }
      }
    }
    log(-1);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
