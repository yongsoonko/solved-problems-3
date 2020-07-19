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
  static int N, M, A[][], chk[][], B[], empty, ans = (int) 1e9;
  static List<Pos> virus = new ArrayList<>();

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    int tc = 1;
    while (tc-- > 0) {
      virus = new ArrayList<>();
      empty = 0;
      ans = (int) 1e9;

      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      A = new int[N][N];
      B = new int[M];

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          A[i][j] = Integer.parseInt(st.nextToken());
          if (A[i][j] == 0)
            empty++;
          else if (A[i][j] == 2)
            virus.add(new Pos(i, j));
        }
      }

      dfs(0, 0);
      log(ans == (int) 1e9 ? "-1 " : ans + " ");
    }

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static void dfs(int curr, int L) {
    if (L == M) {
      int tmp = empty;
      chk = new int[N][N];
      Queue<Pos> Q = new LinkedList<>();

      for (int i : B) {
        Pos v = virus.get(i);
        chk[v.i][v.j] = 1;
        Q.offer(v);
      }

      int time = -1;
      while (Q.size() > 0) {
        time++;
        if (tmp == 0)
          break;
        int sz = Q.size();
        while (sz-- > 0) {
          int ci = Q.peek().i, cj = Q.peek().j;
          Q.poll();

          for (int d = 0; d < 4; d++) {
            int ni = ci + di[d], nj = cj + dj[d];
            if (ni >= 0 && ni < N && nj >= 0 && nj < N && (A[ni][nj] == 0 || A[ni][nj] == 2)
                && chk[ni][nj] == 0) {
              chk[ni][nj] = 1;
              Q.offer(new Pos(ni, nj));
              if (A[ni][nj] == 0)
                tmp--;
            }
          }
        }
      }
      if (tmp == 0 && ans > time)
        ans = time;
    } else if (curr < virus.size()) {
      B[L] = curr;
      dfs(curr + 1, L + 1);
      dfs(curr + 1, L);
    }
  }
}
