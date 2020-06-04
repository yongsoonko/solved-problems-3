import java.io.*;
import java.util.*;

class Pos {
  int x1;
  int y1;
  int x2;
  int y2;

  Pos(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int root[];
  static List<Pos> A;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    root = new int[1001];
    A = new ArrayList<>();
    A.add(new Pos(0, 0, 0, 0));

    int ans = 0;
    boolean once = true;

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      if (once && (x1 * x2 == 0 && y1 * y2 <= 0 || y1 * y2 == 0 && x1 * x2 <= 0)) {
        ans--;
        once = false;
      }

      A.add(new Pos(x1, y1, x2, y2));
      root[i] = -1;
    }

    for (int i = 1; i < N; i++)
      for (int j = i + 1; j <= N; j++)
        if (cross(A.get(i), A.get(j)))
          merge(i, j);

    for (int i = 1; i <= N; i++)
      if (root[i] == -1)
        ans++;

    log(ans);
  }

  static boolean cross(Pos t, Pos u) {
    if (t.x1 < u.x1 && t.y1 < u.y1 && u.x2 < t.x2 && u.y2 < t.y2)
      return false;

    if (u.x1 < t.x1 && u.y1 < t.y1 && t.x2 < u.x2 && t.y2 < u.y2)
      return false;

    if (u.x2 < t.x1 || u.y2 < t.y1 || t.x2 < u.x1 || t.y2 < u.y1)
      return false;

    return true;
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
