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
  static int arr[];
  static boolean chk[];
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[M];
    chk = new boolean[N + 1];
    sb = new StringBuilder();
    dfs(0);
    System.out.println(sb);
  }

  public static void dfs(int cnt) throws IOException {
    if (cnt == M) {
      for (int i : arr)
        sb.append(i).append(' ');
      sb.append('\n');
    } else
      for (int i = 1; i <= N; i++)
        if (!chk[i]) {
          chk[i] = true;
          arr[cnt] = i;
          dfs(cnt + 1);
          chk[i] = false;
        }
  }
}
