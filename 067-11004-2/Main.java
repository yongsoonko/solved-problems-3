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

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int A[] = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(st.nextToken());

    log(select(A, 0, N - 1, K - 1));
  }

  static void swap(int[] A, int i, int j) {
    if (A[i] != A[j]) {
      int tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
    }
  }

  static int select(int[] A, int lt, int rt, int nth) {
    int mid = (lt + rt) / 2;
    swap(A, lt, mid);
    int lo = lt + 1, hi = rt, pv = A[lt];
    while (lo <= hi) {
      while (lo <= rt && A[lo] <= pv)
        lo++;
      while (lt < hi && pv < A[hi])
        hi--;
      if (lo < hi)
        swap(A, lo++, hi--);
    }
    swap(A, lt, hi);
    if (nth < hi)
      return select(A, lt, hi - 1, nth);
    else if (hi < nth)
      return select(A, hi + 1, rt, nth);
    else
      return A[nth];
  }
}
