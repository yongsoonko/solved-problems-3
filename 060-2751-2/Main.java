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
  static int[] B = new int[1000001];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    int A[] = new int[N];
    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    sort(A, 0, N - 1);
    for (int i : A)
      sb.append(i).append('\n');
    log(sb);
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
