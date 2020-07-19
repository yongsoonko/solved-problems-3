import java.io.*;
import java.util.*;

class Pos /* implements Comparable<Pos> */ {
  int i, j, k;

  public Pos(int i, int j, int k) {
    this.i = i;
    this.j = j;
    this.k = k;
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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());
    int A[][][] = new int[H][N][M];

    Queue<Pos> Q = new LinkedList<>();

    for (int k = 0; k < H; k++)
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
          A[k][i][j] = Integer.parseInt(st.nextToken());
          if (A[k][i][j] == 1)
            Q.offer(new Pos(i, j, k));
        }
      }

    int ans = -1;
    while (Q.size() > 0) {
      ans++;
      int sz = Q.size();
      while (sz-- > 0) {
        int ci = Q.peek().i, cj = Q.peek().j, ck = Q.peek().k;
        Q.poll();
        for (int d = 0; d < 6; d++) {
          int ni = ci + di[d], nj = cj + dj[d], nk = ck + dk[d];
          if (ni >= 0 && ni < N && nj >= 0 && nj < M && nk >= 0 && nk < H && A[nk][ni][nj] == 0) {
            A[nk][ni][nj] = 1;
            Q.offer(new Pos(ni, nj, nk));
          }
        }
      }
    }

    for (int k = 0; k < H; k++)
      for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
          if (A[k][i][j] == 0) {
            log(-1);
            return;
          }

    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
