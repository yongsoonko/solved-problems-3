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

  public String toString() {
    return i + " " + j + "\n";
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
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int A[][] = new int[N][M], chk[][] = new int[N][M];

    st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++)
        A[i][j] = Integer.parseInt(st.nextToken());
    }

    int ans = 1;
    chk[r][c] = 1;
    while (true) {
      int i;
      for (i = 3; i >= 0; i--) {
        int nd = (d + i) % 4;
        int ni = r + di[nd], nj = c + dj[nd];
        if (A[ni][nj] == 0 && chk[ni][nj] == 0) {
          chk[ni][nj] = 1;
          r = ni;
          c = nj;
          d = nd;
          ans++;
          break;
        }
      }
      if (i == -1) {
        if (A[r - di[d]][c - dj[d]] == 0) {
          r -= di[d];
          c -= dj[d];
        } else
          break;
      }
    }
    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
