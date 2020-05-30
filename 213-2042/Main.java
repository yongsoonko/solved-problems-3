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
  static long A[], T[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int size = 1 << (int) (Math.ceil(Math.log10(N) / Math.log10(2)) + 1);
    A = new long[N + 1];
    T = new long[size + 1];
    for (int i = 1; i <= N; i++)
      A[i] = Long.parseLong(br.readLine());

    init(1, 1, N);

    for (int i = M + K; i > 0; i--) {
      st = new StringTokenizer(br.readLine());
      String a = st.nextToken();
      int b = Integer.parseInt(st.nextToken());
      long c = Long.parseLong(st.nextToken());
      if (a.charAt(0) == '1') {
        update(1, 1, N, b, c - A[b]);
        A[b] = c; // 여기서 갱신해줘야 다음번에 b위치를 바꿔도 바뀐 값으로 diff가 정해진다.
      } else
        bw.write(query(1, 1, N, b, (int) c) + "\n");
    }
    bw.flush();
  }

  static long init(int node, int start, int end) {
    if (start == end)
      return T[node] = A[start];

    int mid = (start + end) / 2;
    return T[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
  }

  static void update(int node, int start, int end, int pos, long diff) {
    if (pos > end || pos < start)
      return;

    T[node] += diff;

    int mid = (start + end) / 2;
    if (start != end) {
      update(node * 2, start, mid, pos, diff);
      update(node * 2 + 1, mid + 1, end, pos, diff);
    }
  }

  static long query(int node, int start, int end, int lt, int rt) {
    if (lt > end || rt < start)
      return 0;

    if (lt <= start && end <= rt)
      return T[node];

    if (start == end) // 더이상 재귀하지 목하게 한다.
      return T[node];
    else {
      int mid = (start + end) / 2;
      return query(node * 2, start, mid, lt, rt) + query(node * 2 + 1, mid + 1, end, lt, rt);
    }
  }
}
