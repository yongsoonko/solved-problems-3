import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int i, c, s;

  public Pos(int i, int c, int s) {
    this.i = i;
    this.c = c;
    this.s = s;
  }

  @Override
  public int compareTo(Pos o) {
    return s - o.s;
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
    int N = Integer.parseInt(br.readLine());
    Pos A[] = new Pos[N + 1];
    int sum[] = new int[N + 1], colorSum[] = new int[N + 1], ans[] = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int c = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      A[i] = new Pos(i, c, s);
    }

    Arrays.sort(A, 1, N + 1);
    int p = 1, q = 1;
    while (p <= N || q <= N) {
      if (q <= N && A[p].s == A[q].s)
        q++;
      else {
        int r = p;
        while (p < q) {
          ans[A[p].i] = sum[r - 1] - colorSum[A[p].c];
          sum[p] = sum[p - 1] + A[p].s;
          p++;
        }
        while (r < p) {
          colorSum[A[r].c] += A[r].s;
          r++;
        }
      }
    }

    for (int i = 1; i <= N; i++)
      bw.write(ans[i] + "\n");
    bw.flush();

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
