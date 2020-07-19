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
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    char A[][] = new char[N][];
    int chk[][][] = new int[N][M][32];

    Queue<Pos> Q = new LinkedList<>();
    List<Pos> X = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      A[i] = br.readLine().toCharArray();
      for (int j = 0; j < M; j++) {
        if (A[i][j] == 'S') {
          chk[i][j][0] = 1;
          Q.offer(new Pos(i, j, 0));
          A[i][j] = '.';
        } else if (A[i][j] == 'X')
          X.add(new Pos(i, j, 0));
      }
    }

    int ans = 0, end = (1 << X.size()) - 1;
    while (Q.size() > 0) {
      ans++;
      int sz = Q.size();
      while (sz-- > 0) {
        int ci = Q.peek().i, cj = Q.peek().j, cs = Q.peek().state;
        Q.poll();
        for (int d = 0; d < 4; d++) {
          int ni = ci + di[d], nj = cj + dj[d];
          if (A[ni][nj] == '.' && chk[ni][nj][cs] == 0) {
            chk[ni][nj][cs] = 1;
            Q.offer(new Pos(ni, nj, cs));
          } else if (A[ni][nj] == 'X') {
            int i;
            for (i = 0; i < X.size(); i++)
              if (ni == X.get(i).i && nj == X.get(i).j)
                break;
            int nk = cs | (1 << i);
            if (chk[ni][nj][nk] == 0) {
              chk[ni][nj][nk] = 1;
              Q.offer(new Pos(ni, nj, nk));
            }
          } else if (A[ni][nj] == 'E' && cs == end) {
            log(ans);
            return;
          }
        }
      }
    }

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
