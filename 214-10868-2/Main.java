import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int A[], T[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int sz = 1 << ((int) Math.ceil(Math.log10(N) / Math.log10(2)) + 1);
    A = new int[N];
    T = new int[sz];

    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(br.readLine());

    init(1, 0, N - 1);

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      bw.write(query(1, 0, N - 1, a - 1, b - 1) + "\n");
    }
    bw.flush();

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static int init(int node, int start, int end) {
    if (start == end)
      return T[node] = A[start];

    int mid = (start + end) / 2;
    return T[node] = Math.min(init(node * 2, start, mid), init(node * 2 + 1, mid + 1, end));
  }

  static int query(int node, int start, int end, int lt, int rt) {
    if (rt < start || end < lt)
      return (int) 2e9;

    if (lt <= start && end <= rt)
      return T[node];

    int mid = (start + end) / 2;
    return Math.min(query(node * 2, start, mid, lt, rt), query(node * 2 + 1, mid + 1, end, lt, rt));
  }
}
