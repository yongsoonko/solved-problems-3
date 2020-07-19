import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int v, w;

  public Pos(int v, int w) {
    this.v = v;
    this.w = w;
  }

  public int compareTo(Pos o) {
    return w - o.w;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(br.readLine()) - 1;
    int dis[] = new int[V];

    Arrays.fill(dis, (int) 1e9);
    ArrayList<Pos> J[] = new ArrayList[V];

    for (int i = 0; i < V; i++)
      J[i] = new ArrayList<>();

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken()) - 1;
      int v = Integer.parseInt(st.nextToken()) - 1;
      int w = Integer.parseInt(st.nextToken());
      J[u].add(new Pos(v, w));
    }

    PriorityQueue<Pos> Q = new PriorityQueue<>();
    Q.offer(new Pos(K, 0));

    while (Q.size() > 0) {
      int v = Q.peek().v, cost = Q.peek().w;
      Q.poll();

      if (dis[v] < cost)
        continue;

      dis[v] = cost;
      for (Pos next : J[v])
        if (dis[next.v] > cost + next.w) {
          dis[next.v] = cost + next.w;
          Q.offer(new Pos(next.v, dis[next.v]));
        }
    }

    for (int cost : dis) {
      if (cost < (int) 1e9)
        bw.write(cost + "\n");
      else
        bw.write("INF\n");
    }
    bw.flush();

    // System.out.println("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms");
  }
}
