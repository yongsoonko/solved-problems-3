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
    boolean prime[] = new boolean[1000001];
    prime[1] = true;

    for (int i = 2; i * i <= 1000000; i++)
      if (!prime[i])
        for (int j = i + i; j <= 1000000; j += i)
          prime[j] = true;

    int A[] = new int[78498], idx = 0;
    for (int i = 2; i <= 1000000; i++)
      if (!prime[i])
        A[idx++] = i;

    int n;
    while ((n = Integer.parseInt(br.readLine())) != 0) {
      int p = 0, q = Arrays.binarySearch(A, n);
      q = q >= 0 ? q - 1 : -q - 2;
      while (p <= q) {
        if (A[p] + A[q] > n)
          q--;
        else if (A[p] + A[q] < n)
          p++;
        else {
          bw.write(n + " = " + A[p] + " + " + A[q] + "\n");
          break;
        }
      }
    }
    bw.flush();
  }
}
