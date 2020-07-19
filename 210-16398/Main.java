import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int src, dest, cost;

  public Pos(int src, int dest, int cost) {
    this.src = src;
    this.dest = dest;
    this.cost = cost;
  }

  public int compareTo(Pos o) {
    return cost - o.cost;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int R[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    int N = Integer.parseInt(br.readLine());
    int A[][] = new int[N][N];
    R = new int[N];
    PriorityQueue<Pos> Q = new PriorityQueue<>();

    Arrays.fill(R, -1);
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++)
        Q.offer(new Pos(i, j, Integer.parseInt(st.nextToken())));
    }

    long ans = 0, cnt = 1;
    while (cnt < N) {
      int src = Q.peek().src, dest = Q.peek().dest, cost = Q.peek().cost;
      Q.poll();
      if (merge(src, dest)) {
        ans += cost;
        cnt++;
      }
    }

    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static int find(int x) {
    if (R[x] == -1)
      return x;
    return R[x] = find(R[x]);
  }

  static boolean merge(int x, int y) {
    x = find(x);
    y = find(y);
    if (x != y) {
      R[x] = y;
      return true;
    } else
      return false;
  }
}
