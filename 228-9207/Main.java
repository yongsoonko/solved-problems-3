import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, maxCnt, pinCnt;
  static Set<Long> chk[] = new Set[10];
  static char[][] A = new char[5][9];

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      maxCnt = pinCnt = 0;
      for (int j = 0; j < 10; j++)
        chk[j] = new HashSet<>();

      for (int j = 0; j < 5; j++) {
        A[j] = br.readLine().toCharArray();
        for (int k = 0; k < 9; k++)
          if (A[j][k] == 'o')
            pinCnt++;
      }

      long currState = getState();
      chk[0].add(currState);
      dfs(currState, 0);
      bw.write((pinCnt - maxCnt) + " " + maxCnt + "\n");
      br.readLine();
    }
    bw.flush();

    // System.out.println("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms");
  }

  static void dfs(long currState, int dth) {
    if (dth > maxCnt)
      maxCnt = dth;
    if (dth >= pinCnt - 1)
      return;

    int remain = pinCnt - dth;
    for (int i = 0; i < remain; i++) {
      int ci = (int) ((currState / 10) % 10), cj = (int) (currState % 10);
      currState /= 100;
      for (int d = 0; d < 4; d++) {
        int ni = ci + di[d], nj = cj + dj[d];
        if (ni >= 0 && ni < 5 && nj >= 0 && nj < 9 && ni + di[d] >= 0 && ni + di[d] < 5
            && nj + dj[d] >= 0 && nj + dj[d] < 9 && A[ni][nj] == 'o'
            && A[ni + di[d]][nj + dj[d]] == '.') {
          A[ci][cj] = A[ni][nj] = '.';
          A[ni + di[d]][nj + dj[d]] = 'o';
          long nextState = getState();

          if (chk[dth + 1].add(nextState))
            dfs(nextState, dth + 1);

          A[ci][cj] = A[ni][nj] = 'o';
          A[ni + di[d]][nj + dj[d]] = '.';
        }
      }
    }
  }

  static long getState() {
    long res = 0;

    for (int i = 0; i < 5; i++)
      for (int j = 0; j < 9; j++)
        if (A[i][j] == 'o')
          res = res * 100 + i * 10 + j;
    return res;
  }
}
