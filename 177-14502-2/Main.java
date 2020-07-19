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
  static int N, M, A[][], chk[][], empty, ans, round = 1;
  static List<Pos> virus = new ArrayList<>();

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[N][M];
    chk = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
        if (A[i][j] == 2)
          virus.add(new Pos(i, j));
        else if (A[i][j] == 0)
          empty++;
      }
    }

    empty -= 3;
    dfs(0, 0, 0);
    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static void dfs(int ci, int cj, int L) {
    if (L == 3) {
      int tmp = empty + virus.size();
      Queue<Pos> Q = new LinkedList<>();
      for (Pos v : virus) {
        chk[v.i][v.j] = round;
        Q.offer(v);
      }

      while (Q.size() > 0) {
        int vi = Q.peek().i, vj = Q.peek().j;
        Q.poll();
        tmp--;
        for (int d = 0; d < 4; d++) {
          int ni = vi + di[d], nj = vj + dj[d];
          if (ni >= 0 && ni < N && nj >= 0 && nj < M && chk[ni][nj] < round && A[ni][nj] == 0) {
            chk[ni][nj] = round;
            Q.offer(new Pos(ni, nj));
          }
        }
      }
      round++;
      if (ans < tmp)
        ans = tmp;
    } else
      for (int i = ci; i < N; i++)
        for (int j = (i == ci ? cj : 0); j < M; j++)
          if (A[i][j] == 0) {
            A[i][j] = 1;
            dfs(i, j, L + 1);
            A[i][j] = 0;
          }
  }
}
