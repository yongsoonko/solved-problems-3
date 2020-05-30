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
  static boolean chk[];
  static int J[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());

      chk = new boolean[N + 1];
      J = new int[N + 1];
      for (int i = 1; i <= N; i++)
        J[i] = Integer.parseInt(st.nextToken());

      int ans = 0;
      for (int i = 1; i <= N; i++)
        if (!chk[i]) {
          bfs(i);
          // dfs(i);
          ans++;
        }
      bw.write(ans + "\n");
    }
    bw.flush();
  }

  static void dfs(int curr) {
    chk[curr] = true;
    int next;
    if (!chk[next = J[curr]])
      dfs(next);
  }

  static void bfs(int curr) {
    chk[curr] = true;
    Queue<Integer> Q = new LinkedList<>();

    Q.offer(curr);
    while (Q.size() > 0) {
      curr = Q.poll();
      int next;
      if (!chk[next = J[curr]]) {
        chk[next] = true;
        bfs(next);
      }
    }
  }
}
