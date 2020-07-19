import java.io.*;
import java.util.*;

class Pos /* implements Comparable<Pos> */ {
  int i, j, state;

  public Pos(int i, int j, int state) {
    this.i = i;
    this.j = j;
    this.state = state;
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
    int A[][] = new int[N][M];
    int chk[][][] = new int[N][M][2];

    for (int i = 0; i < N; i++) {
      char str[] = br.readLine().toCharArray();
      for (int j = 0; j < M; j++)
        A[i][j] = str[j] - '0';
    }

    chk[0][0][0] = 1;
    Queue<Pos> Q = new LinkedList<>();
    Q.offer(new Pos(0, 0, 0));

    int ans = 1;
    while (Q.size() > 0) {
      if (chk[N - 1][M - 1][0] == 1 || chk[N - 1][M - 1][1] == 1) {
        log(ans);
        System.exit(0);
      }
      ans++;
      int sz = Q.size();
      while (sz-- > 0) {
        int ci = Q.peek().i, cj = Q.peek().j, cs = Q.peek().state;
        Q.poll();
        for (int d = 0; d < 4; d++) {
          int ni = ci + di[d], nj = cj + dj[d];
          if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
            if (cs == 0 && chk[ni][nj][A[ni][nj]] == 0) {
              chk[ni][nj][A[ni][nj]] = 1;
              Q.offer(new Pos(ni, nj, A[ni][nj]));
            } else if (cs == 1 && A[ni][nj] == 0 && chk[ni][nj][1] == 0) {
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
