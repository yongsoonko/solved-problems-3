import java.io.*;
import java.util.*;

class Pos {
  int i;
  int j;

  Pos(int i, int j) {
    this.i = i;
    this.j = j;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int dis[];
  static List<List<Pos>> J;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int V = Integer.parseInt(br.readLine());
    dis = new int[V + 1];
    J = new ArrayList<>();
    for (int i = 0; i <= V; i++)
      J.add(new ArrayList<>());

    for (int i = 1; i <= V; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b;
      while ((b = Integer.parseInt(st.nextToken())) != -1) {
        int c = Integer.parseInt(st.nextToken());
        J.get(a).add(new Pos(b, c));
      }
    }
    Pos res = bfs(1);
    Arrays.fill(dis, 0);
    log(bfs(res.i).j - 1);
  }

  static Pos bfs(int curr) {
    Queue<Integer> Q = new LinkedList<>();
    Q.offer(curr);
    dis[curr] = 1;
    Pos res = new Pos(0, 0);

    while (Q.size() > 0) {
      curr = Q.poll();
      for (Pos next : J.get(curr))
        if (dis[next.i] == 0) {
          dis[next.i] = dis[curr] + next.j;
          Q.offer(next.i);
          if (res.j < dis[next.i]) {
            res.j = dis[next.i];
            res.i = next.i;
          }
        }
    }
    return res;
  }
}
