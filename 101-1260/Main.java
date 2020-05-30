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
  static boolean chk[] = new boolean[1001];
  static ArrayList<ArrayList<Integer>> E = new ArrayList<>();

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++)
      E.add(new ArrayList<>());

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      E.get(a).add(b);
      E.get(b).add(a);
    }

    for (int i = 1; i <= N; i++)
      Collections.sort(E.get(i));

    dfs(V);
    bw.write('\n');
    Arrays.fill(chk, false);
    bfs(V);
    bw.flush();
  }

  static void dfs(int curr) throws IOException {
    chk[curr] = true;
    bw.write(curr + " ");

    for (int next : E.get(curr))
      if (!chk[next])
        dfs(next);
  }

  static void bfs(int curr) throws IOException {
    chk[curr] = true;
    Queue<Integer> Q = new LinkedList<>();
    Q.offer(curr);

    while (Q.size() > 0) {
      curr = Q.poll();
      bw.write(curr + " ");
      for (int next : E.get(curr))
        if (!chk[next]) {
          chk[next] = true;
          Q.offer(next);
        }
    }
  }

}
