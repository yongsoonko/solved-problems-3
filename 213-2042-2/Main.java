import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static long A[], T[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int sz = 1 << ((int) Math.ceil(Math.log10(N) / Math.log10(2)) + 1);
    A = new long[N];
    T = new long[sz];

    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(br.readLine());

    init(1, 0, N - 1);

    for (int i = 0; i < M + K; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      if (a == 1) {
        update(1, 0, N - 1, b - 1, c - A[b - 1]);
        A[b - 1] = c;
      } else if (a == 2)
        bw.write(query(1, 0, N - 1, b - 1, c - 1) + "\n");
    }
    bw.flush();


    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static long init(int node, int start, int end) {
    if (start == end)
      return T[node] = A[start];

    int mid = (start + end) / 2;
    return T[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
  }

  static void update(int node, int start, int end, int idx, long diff) {
    if (idx < start || end < idx)
      return;

    T[node] += diff;

    if (start != end) {
      int mid = (start + end) / 2;
      update(node * 2, start, mid, idx, diff);
      update(node * 2 + 1, mid + 1, end, idx, diff);
    }
  }

  static long query(int node, int start, int end, int lt, int rt) {
    if (rt < start || end < lt)
      return 0;

    if (lt <= start && end <= rt)
      return T[node];

    int mid = (start + end) / 2;
    return query(node * 2, start, mid, lt, rt) + query(node * 2 + 1, mid + 1, end, lt, rt);
  }
}
