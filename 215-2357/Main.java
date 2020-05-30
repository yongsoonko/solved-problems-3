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
  static int A[];
  static Pos T[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int size = 1 << (int) (Math.ceil(Math.log10(N) / Math.log10(2))) + 1;
    A = new int[N + 1];
    T = new Pos[size];

    for (int i = 1; i <= N; i++)
      A[i] = Integer.parseInt(br.readLine());

    init(1, 1, N);

    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      Pos p = query(1, 1, N, a, b);
      bw.write(p.i + " " + p.j + "\n");
    }
    bw.flush();
  }

  static Pos init(int node, int start, int end) {
    if (start == end)
      return T[node] = new Pos(A[start], A[start]);

    int mid = (start + end) / 2;
    Pos a = init(node * 2, start, mid), b = init(node * 2 + 1, mid + 1, end);
    return T[node] = new Pos(Math.min(a.i, b.i), Math.max(a.j, b.j));
  }

  static Pos query(int node, int start, int end, int lt, int rt) {
    if (lt > end || rt < start)
      return new Pos((int) 2e9, (int) -2e9);

    if (lt <= start && end <= rt)
      return T[node];

    int mid = (start + end) / 2;
    Pos a = query(node * 2, start, mid, lt, rt), b = query(node * 2 + 1, mid + 1, end, lt, rt);
    return new Pos(Math.min(a.i, b.i), Math.max(a.j, b.j));
  }
}
