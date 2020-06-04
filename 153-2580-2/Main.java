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
  static int A[][] = new int[9][9];
  static int D[] = new int[10];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int mul = 1;
    for (int i = 0; i < 9; i++, mul <<= 1) {
      D[i] = mul;
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++)
        A[i][j] = Integer.parseInt(st.nextToken());
    }
    D[9] = mul;

    dfs(0, 0);
    bw.flush();
  }

  static boolean dfs(int ci, int cj) throws IOException {
    int chk = 0, i = 0, j = 0;
    out: for (i = ci; i < 9; i++)
      for (j = i == ci ? cj : 0; j < 9; j++)
        if (A[i][j] == 0) {
          int bi = (i / 3) * 3, bj = (j / 3) * 3;
          for (int d = 0; d < 9; d++) {
            chk |= D[A[i][d]];
            chk |= D[A[d][j]];
            chk |= D[A[bi + d / 3][bj + d % 3]];
          }
          break out;
        }

    if (i == 9) {
      for (int a[] : A) {
        for (int d : a)
          bw.write(d + " ");
        bw.write('\n');
      }
      return true;
    }

    chk >>>= 1;
    for (int d = 1; d <= 9; d++, chk >>>= 1)
      if ((chk & 1) == 0) {
        A[i][j] = d;
        if (dfs(i, j))
          return true;
      }

    A[i][j] = 0;
    return false;
  }
}
