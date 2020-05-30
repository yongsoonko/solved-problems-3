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
  static int B[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int A[] = new int[N];
    B = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(st.nextToken());

    sort(A, 0, N - 1);
    log(A[K - 1]);
  }

  static void sort(int[] A, int lt, int rt) {
    if (lt >= rt)
      return;

    int mid = (lt + rt) / 2;
    sort(A, lt, mid);
    sort(A, mid + 1, rt);

    int p = lt, q = mid + 1, r = lt;
    while (p <= mid && q <= rt) {
      if (A[p] < A[q])
        B[r++] = A[p++];
      else
        B[r++] = A[q++];
    }

    while (p <= mid)
      B[r++] = A[p++];

    while (q <= rt)
      B[r++] = A[q++];

    for (int i = lt; i <= rt; i++)
      A[i] = B[i];
  }
}
