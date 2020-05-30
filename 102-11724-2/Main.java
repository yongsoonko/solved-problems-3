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

  static int[] root = new int[1001];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    Arrays.fill(root, -1);

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      merge(a, b);
    }

    int ans = 0;
    for (int i = 1; i <= N; i++)
      if (root[i] == -1)
        ans++;
    log(ans);
  }

  static int find(int x) {
    if (root[x] == -1)
      return x;
    return root[x] = find(root[x]);
  }

  static void merge(int x, int y) {
    x = find(x);
    y = find(y);
    if (x != y)
      root[x] = y;
  }
}
