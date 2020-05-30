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
  static int chk[];
  static List<List<Pos>> J;
  static int maxDis, maxIdx;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int V = Integer.parseInt(br.readLine());
    chk = new int[V + 1];
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
    dfs(1, 0);
    Arrays.fill(chk, 0);
    dfs(maxIdx, 0);
    log(maxDis);
  }

  static void dfs(int curr, int dis) {
    chk[curr] = 1;
    for (Pos next : J.get(curr))
      if (chk[next.i] == 0)
        dfs(next.i, dis + next.j);

    if (maxDis < dis) {
      maxDis = dis;
      maxIdx = curr;
    }
  }
}
