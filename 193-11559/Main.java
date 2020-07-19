import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    char A[][] = new char[12][];

    for (int i = 0; i < 12; i++)
      A[i] = br.readLine().toCharArray();

    int ans = 0;
    Queue<Integer> Q = new LinkedList<>();
    while (true) {
      int chk[][] = new int[12][6];
      int flag = 0;
      for (int i = 0; i < 12; i++)
        for (int j = 0; j < 6; j++)
          if (A[i][j] != '.' && chk[i][j] == 0) {
            List<Integer> cnt = new ArrayList<>();
            chk[i][j] = 1;
            Q.offer(i * 20 + j);

            while (Q.size() > 0) {
              int ci = Q.peek() / 20, cj = Q.peek() % 20;
              Q.poll();
              cnt.add(ci * 20 + cj);
              for (int d = 0; d < 4; d++) {
                int ni = ci + di[d], nj = cj + dj[d];
                if (ni >= 0 && ni < 12 && nj >= 0 && nj < 6 && A[ni][nj] == A[i][j]
                    && chk[ni][nj] == 0) {
                  chk[ni][nj] = 1;
                  Q.offer(ni * 20 + nj);
                }
              }
            }
            if (cnt.size() >= 4) {
              for (int next : cnt)
                A[next / 20][next % 20] = '.';
              flag = 1;
            }
          }

      if (flag == 0) {
        log(ans);
        return;
      }
      ans++;

      for (int j = 0; j < 6; j++)
        for (int p = 11, q = 11; q >= 0; q--)
          if (A[q][j] != '.') {
            A[p][j] = A[q][j];
            if (p > q)
              A[q][j] = '.';
            p--;
          }
    }

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
