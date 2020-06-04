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
  static int root[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    int A[][] = new int[1001][1001];
    root = new int[1001];

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      x1 += 500;
      y1 += 500;
      x2 += 500;
      y2 += 500;

      root[i] = -1;
      for (int j = x1; j <= x2; j++) {
        if (A[j][y1] >= 1)
          merge(i, A[j][y1]);
        if (A[j][y2] >= 1)
          merge(i, A[j][y2]);
        A[j][y1] = A[j][y2] = i;
      }
      for (int j = y1 + 1; j < y2; j++) {
        if (A[x1][j] >= 1)
          merge(i, A[x1][j]);
        if (A[x2][j] >= 1)
          merge(i, A[x2][j]);
        A[x1][j] = A[x2][j] = i;
      }
    }

    int ans = A[500][500] >= 1 ? -1 : 0;
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
