import java.io.*;
import java.util.*;

class Pos {
  int i;
  int j;
  int A[][];

  Pos(int i, int j, int A[][]) {
    this.i = i;
    this.j = j;
    this.A = A;
  }

  public int hashCode() {
    return Arrays.deepHashCode(A);
  }

  public boolean equals(Object o) {
    Pos p = (Pos) o;
    return Arrays.deepEquals(A, p.A) ? true : false;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int A[][] = new int[3][3];
    int E[][] = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    int zi = 0, zj = 0;
    for (int i = 0; i < 3; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
        if (A[i][j] == 0) {
          zi = i;
          zj = j;
        }
      }
    }

    Pos curr = new Pos(zi, zj, A), end = new Pos(2, 2, E);

    Set<Pos> chk = new HashSet<>();
    Queue<Pos> Q = new LinkedList<>();

    chk.add(curr);
    Q.offer(curr);

    int ans = 0;
    out: while (Q.size() > 0) {
      if (chk.contains(end)) {
        log(ans);
        return;
      }
      ans++;
      int sz = Q.size();
      while (sz-- > 0) {
        zi = Q.peek().i;
        zj = Q.peek().j;
        A = Q.peek().A;
        Q.poll();
        for (int i = 0; i < 4; i++) {
          int ni = zi + di[i], nj = zj + dj[i];
          if (ni >= 0 && ni < 3 && nj >= 0 && nj < 3) {
            int B[][] = new int[3][];
            for (int d = 0; d < 3; d++)
              B[d] = Arrays.copyOf(A[d], A[d].length);
            swap(B, zi, zj, ni, nj);
            Pos next = new Pos(ni, nj, B);
            if (chk.add(next)) {
              Q.offer(next);

              if (Arrays.deepEquals(B, E))
                continue out;
            }
          }
        }
      }
    }
    log(-1);
  }

  static void swap(int A[][], int i1, int j1, int i2, int j2) {
    int tmp = A[i1][j1];
    A[i1][j1] = A[i2][j2];
    A[i2][j2] = tmp;
  }
}
