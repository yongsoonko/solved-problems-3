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
  static int T[], A[];

  static void log(Object o) {
    System.out.print(o);
  }


  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    int size = 1 << (int) (Math.ceil(Math.log10(1000000) / Math.log10(2))) + 1;

    A = new int[N];
    T = new int[size];

    int max = 0;
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(br.readLine());
      if (max < A[i])
      max = A[i];
    }
    
    int ans = 0;
    for(int i: A){
      ans = Math.max(ans, query(1, 0, max, i + 1, max));
      update(1, 0, max, i);
    }
    log(ans + 1);
  }

  static int query(int node, int start, int end, int lt, int rt) {
    if (rt < start || end < lt)
      return 0;

    if (lt <= start && end <= rt)
      return T[node];

    int mid = (start + end) / 2;
    return query(node * 2, start, mid, lt, rt) + query(node * 2 + 1, mid + 1, end, lt, rt);
  }

  static void update(int node, int start, int end, int pos) {
    if (pos < start || end < pos)
      return;

    T[node]++;

    if (start != end) {
      int mid = (start + end) / 2;
      update(node * 2, start, mid, pos);
      update(node * 2 + 1, mid + 1, end, pos);
    }
  }
}
