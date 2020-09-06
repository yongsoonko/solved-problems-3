import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int dx[] = {1, 0, -1, 0}, dy[] = {0, -1, 0, 1};
  static int N, A[][] = new int[101][101], ans;
  static List<Integer> J;

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int g = Integer.parseInt(st.nextToken());

      J = new ArrayList<>();
      J.add(d);

      for (int j = 0; j < g; j++) {
        List<Integer> nJ = new ArrayList<>();
        for (int k = J.size() - 1; k >= 0; k--)
          nJ.add((J.get(k) + 1) % 4);
        J.addAll(nJ);
      }

      A[x][y] = 1;
      for (int dir : J)
        A[x += dx[dir]][y += dy[dir]] = 1;
    }

    for (int i = 0; i < 100; i++)
      for (int j = 0; j < 100; j++)
        if (A[i][j] * A[i + 1][j] * A[i][j + 1] * A[i + 1][j + 1] == 1)
          ans++;

    System.out.println(ans);

    // System.out.println("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms");
  }
}
