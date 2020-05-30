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

  static void swap(int[] A, int i, int j) {
    if (A[i] != A[j]) {
      A[i] ^= A[j];
      A[j] ^= A[i];
      A[i] ^= A[j];
    }
  }

  static void sort(int[] A, int lt, int rt) {
    if (lt >= rt)
      return;

    int mid = (lt + rt) / 2;
    swap(A, lt, mid);
    int pv = A[lt], lo = lt + 1, hi = rt;
    while (lo <= hi) {
      while (lo <= rt && A[lo] <= pv)
        lo++;
      while (lt < hi && pv < A[hi])
        hi--;
      if (lo < hi)
        swap(A, lo++, hi--);
    }
    swap(A, lt, hi);
    sort(A, lt, hi - 1);
    sort(A, hi + 1, rt);
  }
}
