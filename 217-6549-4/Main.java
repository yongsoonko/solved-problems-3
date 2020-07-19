import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int A[], T[], N;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    String str;
    while ((str = br.readLine()).charAt(0) != '0') {
      StringTokenizer st = new StringTokenizer(str);
      N = Integer.parseInt(st.nextToken());
      int sz = 1 << (int) Math.ceil(Math.log10(N) / Math.log10(2)) + 1;
      A = new int[N + 1];
      T = new int[sz];

      for (int i = 0; i < N; i++)
        A[i] = Integer.parseInt(st.nextToken());
      A[N] = (int) 2e9;

      init(1, 0, N - 1);
      bw.write(dfs(0, N - 1) + "\n");
    }
    bw.flush();
  }

  static long dfs(int lt, int rt) {
    if (lt == rt)
      return A[lt];
    if (lt > rt)
      return 0;

    int minIdx = query(1, 0, N - 1, lt, rt);
    long ltMax = dfs(lt, minIdx - 1);
    long rtMax = dfs(minIdx + 1, rt);
    long res = Math.max(ltMax, rtMax);
    return Math.max(res, (long) (rt - lt + 1) * A[minIdx]);
  }

  static int init(int node, int start, int end) {
    if (start == end) {
      T[node] = start;
      return start;
    }

    int mid = (start + end) / 2;
    int ltIdx = init(node * 2, start, mid);
    int rtIdx = init(node * 2 + 1, mid + 1, end);
    return T[node] = A[ltIdx] < A[rtIdx] ? ltIdx : rtIdx;
  }

  static int query(int node, int start, int end, int lt, int rt) {
    if (rt < start || end < lt)
      return N;

    if (lt <= start && end <= rt)
      return T[node];

    int mid = (start + end) / 2;
    int ltIdx = query(node * 2, start, mid, lt, rt);
    int rtIdx = query(node * 2 + 1, mid + 1, end, lt, rt);
    return A[ltIdx] < A[rtIdx] ? ltIdx : rtIdx;
  }
}
