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
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, E, W[][];
  static Map<List<Boolean>, Integer> cache;
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


    ArrayList<Boolean> start = new ArrayList<>();
    for (int i = 0; i < N; i++)
      start.add(false);
    start.set(0, true);

    log(dfs(start, 0));
  }

  static int dfs(List<Boolean> state, int curr) {
    int i;
    for (i = 0; i < N && state.get(i); i++);
    if (i == N)
      return W[curr][0] > 0 ? W[curr][0] : (int) 1e9;

    Integer res;
    if ((res = cache.get(state)) != null)
      return res;

    res = (int) 1e9;
    for (int next = 0; next < N; next++)
      if (!state.get(next) && W[curr][next] > 0) {
        state.set(next, true);
        res = Math.min(res, W[curr][next] + dfs(state, next));
        state.set(next, false);
      }

    cache.put(state, res);
    return res;
  }
}
