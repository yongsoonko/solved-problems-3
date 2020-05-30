import java.io.*;
import java.util.*;

class Pos {
  int i;
  int j;
  int k;

  Pos(int i, int j, int k) {
    this.i = i;
    this.j = j;
    this.k = k;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int A[][] = new int[101][101];
  static int dis[][] = new int[101][101];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++)
        A[i][j] = Integer.parseInt(st.nextToken());
    }

    Queue<Pos> Q = new LinkedList<>();
    Queue<Pos> Q2 = new LinkedList<>();
    int idx = 1;
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        if (A[i][j] == 1) {
          A[i][j] = ++idx;
          Q.offer(new Pos(i, j, 0));

          while (Q.size() > 0) {
            int ci = Q.peek().i, cj = Q.peek().j;
            Q.poll();

            boolean once = true;
            for (int k = 0; k < 4; k++) {
              int ni = ci + di[k], nj = cj + dj[k];
              if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                if (A[ni][nj] == 1) {
                  A[ni][nj] = idx;
                  Q.offer(new Pos(ni, nj, 0));
                } else if (once && A[ni][nj] == 0) {
                  once = false;
                  Q2.offer(new Pos(ci, cj, idx));
                }
              }
            }
          }
        }

    int ans = (int) 1e9;
    while (Q2.size() > 0) {
      int sz = Q2.size();
      while (sz-- > 0) {
        int ci = Q2.peek().i, cj = Q2.peek().j, ck = Q2.peek().k;
        Q2.poll();
        for (int i = 0; i < 4; i++) {
          int ni = ci + di[i], nj = cj + dj[i];
          if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
            if (A[ni][nj] == 0) {
              dis[ni][nj] = dis[ci][cj] + 1;
              A[ni][nj] = ck;
              Q2.offer(new Pos(ni, nj, ck));
            } else if (A[ni][nj] != ck)
              ans = Math.min(ans, dis[ni][nj] + dis[ci][cj]);
          }
        }
      }
      if (ans < (int) 1e9) {
        log(ans);
        return;
      }
    }
  }
}
