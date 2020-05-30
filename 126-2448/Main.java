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
  static char A[][];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    A = new char[N][N * 2 - 1];
    for (int i = 0; i < N; i++)
      Arrays.fill(A[i], ' ');

    dfs(0, N - 1, N);
    for (char[] a : A) {
      bw.write(a);
      bw.write('\n');
    }
    bw.flush();
  }

  static void dfs(int ci, int cj, int size) {
    if (size == 3) {
      A[ci][cj] = A[ci + 1][cj - 1] = A[ci + 1][cj + 1] = '*';
      for (int j = -2; j <= 2; j++)
        A[ci + 2][cj + j] = '*';
      return;
    }
    size /= 2;
    dfs(ci, cj, size);
    dfs(ci + size, cj - size, size);
    dfs(ci + size, cj + size, size);
  }
}
