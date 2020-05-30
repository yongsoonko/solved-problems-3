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
  static int[] A;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[M];
    sb = new StringBuilder();

    dfs(1, 0);
    System.out.print(sb);
  }

  static void dfs(int curr, int cnt) {
    if (cnt == M) {
      for (int i : A)
        sb.append(i).append(' ');
      sb.append('\n');
    } else
      for (int i = curr; i <= N; i++) {
        A[cnt] = i;
        dfs(i, cnt+1);
      }
  }
}
