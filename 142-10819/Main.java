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
  static int ans, N, A[], B[], chk[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    A = new int[N];
    B = new int[N];
    chk = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(st.nextToken());

    dfs(0);
    log(ans);
  }

  static void dfs(int curr) {
    if (curr == N) {
      int sum = 0;
      for (int i = 0; i < N - 1; i++)
        sum += Math.abs(B[i] - B[i + 1]);
      ans = Math.max(ans, sum);
    } else
      for (int i = 0; i < N; i++)
        if (chk[i] == 0) {
          chk[i] = 1;
          B[curr] = A[i];
          dfs(curr + 1);
          chk[i] = 0;
        }
  }
}
