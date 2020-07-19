import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, W[][], cache[][], end;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    N = Integer.parseInt(br.readLine());
    W = new int[N][N];
    cache = new int[N][1 << N];
    end = (1 << N) - 1;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++)
        W[i][j] = Integer.parseInt(st.nextToken());
    }

    log(dfs(0, 1, 0));

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static int dfs(int curr, int state, int cost) {
    int res = (int) 1e9;
    if (state == end && W[curr][0] > 0)
      return cost + W[curr][0];
    if (cache[curr][state] == -1)
      return res;
    if (cache[curr][state] > 0)
      return cost + cache[curr][state];

    // when cache[curr][state] == 0
    for (int next = 0; next < N; next++)
      if (W[curr][next] > 0 && (state & (1 << next)) == 0)
        res = Math.min(res, dfs(next, state | (1 << next), W[curr][next]));

    if (res == (int) 1e9) {
      cache[curr][state] = -1;
      return res;
    } else
      return cost + (cache[curr][state] = res);
  }
}
