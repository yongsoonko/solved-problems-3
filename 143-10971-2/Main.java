import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

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
  static int N, W[][], ans = (int) 1e9;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    W = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++)
        W[i][j] = Integer.parseInt(st.nextToken());
    }

    int A[] = IntStream.range(0, N).toArray();
    do {
      int sum = 0, i;
      for (i = 0; i < N - 1; i++) {
        if (W[A[i]][A[i + 1]] > 0)
          sum += W[A[i]][A[i + 1]];
        else
          break;
      }
      if (i == N - 1 && W[A[N - 1]][A[0]] > 0)
        ans = Math.min(ans, sum + W[A[N - 1]][A[0]]);
    } while (next_permutation(A, 1, N));

    log(ans);
  }

  static void swap(int A[], int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
  }

  static boolean next_permutation(int A[], int start, int end) {
    int pv = start;
    for (int i = start + 1; i < end; i++)
      if (A[i - 1] < A[i])
        pv = i;

    if (pv == start)
      return false;

    for (int i = end - 1; i >= pv; i--)
      if (A[pv - 1] < A[i]) {
        swap(A, pv - 1, i);
        break;
      }

    int p = pv, q = end - 1;
    while (p < q)
      swap(A, p++, q--);

    return true;
  }
}
