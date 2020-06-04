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
  static int R, C, ans = 1;
  static int chk[] = new int[26];
  static char A[][];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    A = new char[R][];
    for (int i = 0; i < R; i++)
      A[i] = br.readLine().toCharArray();

    chk[A[0][0] - 'A'] = 1;
    dfs(0, 0, 1);
    log(ans);
  }

  static boolean dfs(int ci, int cj, int cnt) {
    if (ans < cnt)
      ans = cnt;
    if (cnt == 26)
      return true;
    else {
      for (int i = 0; i < 4; i++) {
        int ni = ci + di[i], nj = cj + dj[i];
        if (ni >= 0 && ni < R && nj >= 0 && nj < C && chk[A[ni][nj] - 'A'] == 0) {
          chk[A[ni][nj] - 'A'] = 1;
          if (dfs(ni, nj, cnt + 1))
            return true;
          chk[A[ni][nj] - 'A'] = 0;
        }
      }
      return false;
    }
  }
}
