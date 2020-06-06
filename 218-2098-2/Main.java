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
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, W[][], E, cache[][];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    W = new int[N][N];
    cache = new int[N][1 << N];
    E = (1 << N) - 1;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++)
        W[i][j] = Integer.parseInt(st.nextToken());
    }

    cache[0][1 << 0] = 0;
    log(dfs(0, 1 << 0));
  }

  static int dfs(int curr, int chk) {
    if (chk == E)
      return W[curr][0] > 0 ? W[curr][0] : (int) 1e9;

    if (cache[curr][chk] > 0)
      return cache[curr][chk];

    int res = (int) 1e9;
    for (int next = 0; next < N; next++) {
      int nChk = 1 << next;
      if ((chk & nChk) == 0 && W[curr][next] > 0) {
        chk |= nChk;
        res = Math.min(res, W[curr][next] + dfs(next, chk));
        chk ^= nChk;
      }
    }

    return cache[curr][chk] = res;
  }
}
