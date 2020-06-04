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
  static int K, S[], seq[], ans[] = new int[6];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    String str;
    while ((str = br.readLine()).charAt(0) != '0') {
      StringTokenizer st = new StringTokenizer(str);
      K = Integer.parseInt(st.nextToken());
      S = new int[K];
      seq = new int[K];
      for (int i = 0; i < K; i++)
        S[i] = Integer.parseInt(st.nextToken());
      for (int i = 6; i < K; i++)
        seq[i] = 1;

      do {
        for (int i = 0; i < K; i++)
          if (seq[i] == 0)
            bw.write(S[i] + " ");
        bw.write('\n');
      } while (next_permutation(seq));
      bw.write('\n');
    }
    bw.flush();
  }

  static boolean next_permutation(int A[]) {
    int pv = 0;
    for (int i = 1; i < A.length; i++)
      if (A[i - 1] < A[i])
        pv = i;

    if (pv == 0)
      return false;

    for (int i = A.length - 1; i >= pv; i--)
      if (A[pv - 1] < A[i]) {
        swap(A, pv - 1, i);
        break;
      }

    int p = pv, q = A.length - 1;
    while (p < q)
      swap(A, p++, q--);

    return true;
  }

  static void swap(int A[], int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
  }
}
