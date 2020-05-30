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
  static int root[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());

      root = new int[N + 1];
      Arrays.fill(root, -1);
      for (int i = 1; i <= N; i++)
        merge(i, Integer.parseInt(st.nextToken()));

      int ans = 0;
      for (int i = 1; i <= N; i++)
        if (root[i] == -1)
          ans++;
      bw.write(ans + "\n");
    }
    bw.flush();
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
