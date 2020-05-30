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
  static List<List<Integer>> J;
  static int chk[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int K = Integer.parseInt(br.readLine());
    while (K-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int V = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());

      J = new ArrayList<>();
      for (int i = 0; i <= V; i++)
        J.add(new ArrayList<>());
      chk = new int[V + 1];

      for (int i = 0; i < E; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        J.get(a).add(b);
        J.get(b).add(a);
      }

      int flag = 1;
      for (int i = 1; i <= V; i++)
        if (chk[i] == 0) {
          chk[i] = 1;
          if (!dfs(i)) {
            flag = 0;
            break;
          }
        }
      bw.write(flag == 1 ? "YES\n" : "NO\n");
    }
    bw.flush();
  }

  static boolean dfs(int curr) {
    for (int next : J.get(curr)) {
      if (chk[next] == 0) {
        chk[next] = 3 - chk[curr];
        if (!dfs(next))
          return false;
      } else if (chk[next] == chk[curr])
        return false;
    }
    return true;
  }
}
