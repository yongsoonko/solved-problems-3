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
    A = new char[N][N];

    for (int i = 0; i < N; i++)
      A[i] = br.readLine().toCharArray();

    dfs(0, 0, N);
    bw.flush();
  }

  static void dfs(int ci, int cj, int size) throws IOException {
    int i;
    out: for (i = 0; i < size; i++)
      for (int j = 0; j < size; j++)
        if (A[ci + i][cj + j] != A[ci][cj])
          break out;

    if (i == size) {
      bw.write(A[ci][cj]);
      return;
    }

    size /= 2;
    bw.write('(');
    for (int k = 0; k < 2; k++)
      for (int j = 0; j < 2; j++)
        dfs(ci + size * k, cj + size * j, size);
    bw.write(')');
  }
}
