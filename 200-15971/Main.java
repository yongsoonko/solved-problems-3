import java.io.*;
import java.util.*;

class Pos /* implements Comparable<Pos> */ {
  int i, w;

  public Pos(int i, int w) {
    this.i = i;
    this.w = w;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, chk[], E;
  static List<Pos> J[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    chk = new int[N + 1];
    J = new List[N + 1];
    for (int i = 1; i <= N; i++)
      J[i] = new ArrayList<>();

    for (int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      J[a].add(new Pos(b, c));
      J[b].add(new Pos(a, c));
    }

    chk[S] = 1;
    dfs(S, 0, 0);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static void dfs(int curr, int sum, int max) {
    if (curr == E) {
      log(sum - max);
      System.exit(0);
    } else
      for (Pos p : J[curr])
        if (chk[p.i] == 0) {
          chk[p.i] = 1;
          dfs(p.i, sum + p.w, max < p.w ? p.w : max);
        }
  }
}
