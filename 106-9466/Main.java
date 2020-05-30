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
  static int dis[];
  static int cnt[];
  static int J[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine());
      dis = new int[n + 1];
      cnt = new int[n + 1];
      J = new int[n + 1];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++)
        J[i] = Integer.parseInt(st.nextToken());

      int ans = 0;
      for (int i = 1; i <= n; i++)
        if (dis[i] == 0) {
          dis[i] = 1;
          cnt[i] = i;
          ans += dfs(i);
        }
      bw.write(ans + "\n");
    }
    bw.flush();
  }

  static int dfs(int curr) {
    int next = J[curr];
    if (dis[next] == 0) {
      dis[next] = dis[curr] + 1;
      cnt[next] = cnt[curr];
      return dfs(next);
    } else if (cnt[next] == cnt[curr])
      return dis[next] - 1;
    else
      return dis[curr];
  }
}
