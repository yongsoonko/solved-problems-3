import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int i, j;

  public Pos(int i, int j) {
    this.i = i;
    this.j = j;
  }

  public int compareTo(Pos o) {
    return i == o.i ? j - o.j : i - o.i;
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
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    int A[] = new int[M];
    Pos B[] = new Pos[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++)
      A[i] = Integer.parseInt(st.nextToken());
    Arrays.sort(A);

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      B[i] = new Pos(a, b);
    }
    Arrays.sort(B);

    int p = 0, q = 0, ans = 0, mid = 0;
    while (p < N) {
      int dis = (int) 2e9;
      if (B[p].i <= A[q]) {
        if (q >= 1 && B[p].i <= mid)
          dis = Math.abs(B[p].i - A[q - 1]) + B[p].j;
        else
          dis = Math.min(dis, Math.abs(B[p].i - A[q]) + B[p].j);
        p++;
      } else {
        if (q < M - 1) {
          q++;
          mid = (A[q] + A[q - 1]) / 2;
        } else {
          dis = Math.abs(B[p].i - A[q]) + B[p].j;
          p++;
        }
      }
      if (dis <= L)
        ans++;
    }
    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
