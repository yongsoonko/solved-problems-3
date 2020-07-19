import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int dest, cost;

  public Pos(int dest, int cost) {
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

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    int N = Integer.parseInt(br.readLine());
    int chk[] = new int[N];
    List<Pos> J[] = new List[N];
    PriorityQueue<Pos> Q = new PriorityQueue<>();

    for (int i = 0; i < N; i++)
      J[i] = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        int a = Integer.parseInt(st.nextToken());
        J[i].add(new Pos(j, a));
        J[j].add(new Pos(i, a));
      }
    }

    long ans = 0;
    Q.offer(new Pos(0, 0));
    while (Q.size() > 0) {
      int curr = Q.peek().dest, cost = Q.peek().cost;
      Q.poll();

      if (chk[curr] == 1)
        continue;

      ans += cost;
      for (Pos p : J[curr])
        if (chk[p.dest] == 0)
          Q.offer(p);

      chk[curr] = 1;
    }

    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
