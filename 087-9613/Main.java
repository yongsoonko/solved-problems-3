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

  static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  public static void main(String[] args) throws IOException {
    int t = Integer.parseInt(br.readLine());
    int A[] = new int[101];
    while (t-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      for (int i = 0; i < n; i++)
        A[i] = Integer.parseInt(st.nextToken());
      long sum = 0;
      for (int i = 0; i < n - 1; i++)
        for (int j = i + 1; j < n; j++)
          sum += (long) gcd(A[i], A[j]);
      bw.write(sum + "\n");
    }
    bw.flush();
  }
}
