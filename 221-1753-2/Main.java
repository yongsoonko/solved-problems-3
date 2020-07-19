import java.io.*;
import java.util.*;

class Pos /* implements Comparable<Pos> */ {
  int v, w;

  public Pos(int v, int w) {
    this.v = v;
    this.w = w;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(br.readLine()) - 1;
    int dis[] = new int[V], chk[] = new int[V];

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

    HashSet<Integer> boundary = new HashSet<>();
    boundary.add(K);
    dis[K] = 0;

    for (int cnt = 0; cnt < V - 2; cnt++) {
      int minIdx = -1, min = (int) 1e9;
      for (int candi : boundary)
        if (min > dis[candi]) {
          min = dis[candi];
          minIdx = candi;
        }

      for (Pos next : J[minIdx])
        if (chk[next.v] == 0) {
          if (dis[next.v] > dis[minIdx] + next.w)
            dis[next.v] = dis[minIdx] + next.w;
          boundary.add(next.v);
        }

      boundary.remove(minIdx);
      chk[minIdx] = 1;
    }

    for (int cost : dis) {
      if (cost < (int) 1e9)
        bw.write(cost + "\n");
      else
        bw.write("INF\n");
    }
    bw.flush();

    System.out.println("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms");
  }
}
