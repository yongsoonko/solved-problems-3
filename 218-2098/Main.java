import java.io.*;
import java.util.*;

class Pos {
  int i;
  boolean j[];

  Pos(int i, boolean j[]) {
    this.i = i;
    this.j = j;
  }

  public int hashCode() {
    return 31 * Arrays.hashCode(j) + i;
  }

  public boolean equals(Object o) {
    Pos p = (Pos) o;
    return i == p.i && Arrays.equals(j, p.j);
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, W[][];
  static Map<Pos, Integer> cache;
  // 지금 경로의 이미 방문 노드로 국한하지 않고,
  // 지금 노드의 이미 방문 경로로 가지치기
  // cache가 chk를 대신한다고 보면된다.

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    W = new int[N][N];
    cache = new HashMap<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++)
        W[i][j] = Integer.parseInt(st.nextToken());
    }

    boolean start[] = new boolean[N];
    start[0] = true;
    log(dfs(new Pos(0, start)));
  }

  static int dfs(Pos state) {
    int i, curr = state.i;
    boolean chk[] = state.j;
    for (i = 0; i < N && chk[i]; i++);
    if (i == N)
      return W[curr][0] > 0 ? W[curr][0] : (int) 1e9;

    Integer res;
    if ((res = cache.get(state)) != null)
      return res;

    res = (int) 1e9;
    boolean nChk[] = Arrays.copyOf(chk, N);
    for (int next = 0; next < N; next++)
      if (!nChk[next] && W[curr][next] > 0) {
        nChk[next] = true;
        res = Math.min(res, W[curr][next] + dfs(new Pos(next, nChk)));
        nChk[next] = false;
      }

    cache.put(state, res);
    return res;
  }
}
