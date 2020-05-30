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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int A[] = new int[N];
    int B[] = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++)
      B[i] = Integer.parseInt(st.nextToken());

    int p = 0, q = 0, r = 0;
    while (p < N && q < M) {
      if (A[p] < B[q])
        bw.write(A[p++] + " ");
      else
        bw.write(B[q++] + " ");
    }

    while (p < N)
      bw.write(A[p++] + " ");

    while (q < M)
      bw.write(B[q++] + " ");

    bw.flush();
  }
}
