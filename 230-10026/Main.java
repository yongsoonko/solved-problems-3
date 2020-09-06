import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, chk[][], ans, ans2;
  static char A[][];

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    N = Integer.parseInt(br.readLine());
    A = new char[N][];
    chk = new int[N][N];

    for (int i = 0; i < N; i++)
      A[i] = br.readLine().toCharArray();

    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        if (chk[i][j] == 0) {
          chk[i][j] = 1;
          bfs(i, j);
          ans++;
        }

    chk = new int[N][N];
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        if (chk[i][j] == 0) {
          chk[i][j] = 1;
          bfs2(i, j);
          ans2++;
        }

    System.out.println(ans + " " + ans2);

    // System.out.println("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms");
  }

  static void bfs(int ci, int cj) {
    LinkedList<Integer> Q = new LinkedList<>();
    Q.add(ci * 101 + cj);

    while (Q.size() > 0) {
      ci = Q.peek() / 101;
      cj = Q.peek() % 101;
      Q.poll();
      for (int d = 0; d < 4; d++) {
        int ni = ci + di[d], nj = cj + dj[d];
        if (ni >= 0 && ni < N && nj >= 0 && nj < N && A[ni][nj] == A[ci][cj] && chk[ni][nj] == 0) {
          chk[ni][nj] = 1;
          Q.add(ni * 101 + nj);
        }
      }
    }
  }

  static void bfs2(int ci, int cj) {
    LinkedList<Integer> Q = new LinkedList<>();
    Q.add(ci * 101 + cj);

    while (Q.size() > 0) {
      ci = Q.peek() / 101;
      cj = Q.peek() % 101;
      Q.poll();
      for (int d = 0; d < 4; d++) {
        int ni = ci + di[d], nj = cj + dj[d];
        if (ni >= 0 && ni < N && nj >= 0 && nj < N)
          if (((A[ci][cj] == 'R' && A[ni][nj] == 'G') || (A[ci][cj] == 'G' && A[ni][nj] == 'R')
              || (A[ci][cj] == A[ni][nj])) && chk[ni][nj] == 0) {
            chk[ni][nj] = 1;
            Q.add(ni * 101 + nj);
          }
      }
    }
  }
}
