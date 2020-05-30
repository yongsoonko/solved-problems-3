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
  static int N;
  static char A[][];

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    A = new char[N][N];
    for (int i = 0; i < N; i++)
      Arrays.fill(A[i], '*');

    dfs(0, 0, N);
    for (char[] ch : A) {
      bw.write(ch);
      bw.write('\n');
    }
    bw.flush();
  }

  static void dfs(int ci, int cj, int sz) {
    if (sz == 1)
      return;
    sz /= 3;
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1) {
          for (int k = sz * 2 - 1; k >= sz; k--)
            Arrays.fill(A[ci + k], cj + sz, cj + sz * 2, ' ');
        } else
          dfs(ci + sz * i, cj + sz * j, sz);
      }
  }
}
