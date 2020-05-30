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
  static int A[][];
  static int ans[];
  static int N;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    A = new int[N][N];
    ans = new int[3];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++)
        A[i][j] = Integer.parseInt(st.nextToken());
    }

    dfs(0, 0, N);
    log(ans[2] + "\n" + ans[0] + "\n" + ans[1]);
  }

  static int dfs(int ci, int cj, int size) {
    if (size == 1)
      return A[ci][cj] == -1 ? 2 : A[ci][cj];

    int cnt[] = new int[4];
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        cnt[dfs(ci + size / 3 * i, cj + size / 3 * j, size / 3)]++;

    for (int i = 0; i <= 2; i++)
      if (cnt[i] == 9) {
        if (size == N)
          ans[i]++;
        return i;
      }

    for (int i = 0; i <= 2; i++)
      ans[i] += cnt[i];
    return 3;
  }
}
