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
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    int A[] = new int[N];
    int ans = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(A);

    do {
      int sum = 0;
      for (int i = 0; i < A.length - 1; i++)
        sum += Math.abs(A[i] - A[i + 1]);
      ans = Math.max(ans, sum);
    } while (next_permutation(A));
    log(ans);
  }

  static void swap(int A[], int i, int j) {
    int tmp = A[j];
    A[j] = A[i];
    A[i] = tmp;
  }

  static boolean next_permutation(int A[]) {
    int pv = 0;
    for (int i = 1; i < A.length; i++)
      if (A[i - 1] < A[i])
        pv = i;

    if (pv == 0)
      return false;

    for (int i = A.length - 1; i >= pv; i--)
      if (A[i] > A[pv - 1]) {
        swap(A, i, pv - 1);
        break;
      }

    int p = pv, q = A.length - 1;
    while (p < q)
      swap(A, p++, q--);

    return true;
  }
}
