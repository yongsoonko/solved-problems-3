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
  static int A[], T[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int size = 1 << (int) Math.ceil(Math.log10(N) / Math.log10(2)) + 1;
    A = new int[N + 1];
    T = new int[size + 1];
    for (int i = 1; i <= N; i++)
      A[i] = Integer.parseInt(br.readLine());

    init(1, 1, N);

    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      bw.write(query(1, 1, N, a, b) + "\n");
    }
    bw.flush();
  }

  static int init(int node, int start, int end) {
    if (start == end)
      return T[node] = A[start];

    int mid = (start + end) / 2;
    return T[node] = Math.min(init(node * 2, start, mid), init(node * 2 + 1, mid + 1, end));
  }

  static int query(int node, int start, int end, int lt, int rt) {
    if (lt > end || rt < start)
      return (int) 2e9;

    if (lt <= start && end <= rt)
      return T[node];

    int mid = (start + end) / 2;
    return Math.min(query(node * 2, start, mid, lt, rt), query(node * 2 + 1, mid + 1, end, lt, rt));
  }
}
