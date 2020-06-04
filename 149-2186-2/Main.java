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
  static int N, M, K, cache[][][];
  static char A[][], str[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    A = new char[N][];
    for (int i = 0; i < N; i++)
      A[i] = br.readLine().toCharArray();

    str = br.readLine().toCharArray();
    cache = new int[N][M][str.length];
    for (int i = 0; i < N; i++)
      for (int j = 0; j < M; j++)
        Arrays.fill(cache[i][j], -1);

    int ans = 0;
    for (int i = 0; i < N; i++)
      for (int j = 0; j < M; j++)
        if (A[i][j] == str[str.length - 1])
          ans += dfs(i, j, str.length - 1);

    log(ans);
  }

  static int dfs(int ci, int cj, int cnt) {
    if (cnt == 0)
      return 1;
    if (cache[ci][cj][cnt] >= 0)
      return cache[ci][cj][cnt];

    int sum = 0;
    for (int i = 0; i < 4; i++)
      for (int j = 1; j <= K; j++) {
        int ni = ci + di[i] * j, nj = cj + dj[i] * j;
        if (ni >= 0 && ni < N && nj >= 0 && nj < M && A[ni][nj] == str[cnt - 1])
          sum += dfs(ni, nj, cnt - 1);
      }
    return cache[ci][cj][cnt] = sum;
  }
}
