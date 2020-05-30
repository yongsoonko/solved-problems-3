import java.io.*;
import java.util.*;

class Pos {
  int i, j;

  Pos(int i, int j) {
    this.i = i;
    this.j = j;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N, M;
  static int A[], ans[];
  static boolean chk[];
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[N];
    ans = new int[M];
    chk = new boolean[N + 1];
    sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(A);
    dfs(0);
    System.out.print(sb);
  }

  static void dfs(int cnt) {
    if (cnt == M) {
      for (int i : ans)
        sb.append(i).append(' ');
      sb.append('\n');
    } else
      for (int i = 0; i < N; i++)
        if (!chk[i]) {
          chk[i] = true;
          ans[cnt] = A[i];
          dfs(cnt + 1);
          chk[i] = false;
        }
  }
}
