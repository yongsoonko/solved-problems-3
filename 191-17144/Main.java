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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int T = Integer.parseInt(st.nextToken());
    int A[][] = new int[R][C], tmp[][] = new int[R][C];
    int Hi = 0;

    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < C; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
        if (A[i][j] == -1)
          Hi = i;
      }
    }

    for (int t = 0; t < T; t++) {
      for (int i = 0; i < R; i++)
        for (int j = 0; j < C; j++)
          if (A[i][j] >= 5) {
            int add = A[i][j] / 5;
            for (int d = 0; d < 4; d++) {
              int ni = i + di[d], nj = j + dj[d];
              if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
                if (nj == 0 && (ni == Hi || ni == Hi - 1))
                  continue;
                tmp[ni][nj] += add;
                A[i][j] -= add;
              }
            }
          }
      for (int i = 0; i < R; i++)
        for (int j = 0; j < C; j++) {
          A[i][j] += tmp[i][j];
          tmp[i][j] = 0;
        }

      for (int i = Hi - 2; i > 0; i--)
        A[i][0] = A[i - 1][0];
      for (int j = 0; j < C - 1; j++)
        A[0][j] = A[0][j + 1];
      for (int i = 0; i < Hi - 1; i++)
        A[i][C - 1] = A[i + 1][C - 1];
      for (int j = C - 1; j > 1; j--)
        A[Hi - 1][j] = A[Hi - 1][j - 1];
      A[Hi - 1][1] = 0;

      for (int i = Hi + 1; i < R - 1; i++)
        A[i][0] = A[i + 1][0];
      for (int j = 0; j < C - 1; j++)
        A[R - 1][j] = A[R - 1][j + 1];
      for (int i = R - 1; i > Hi; i--)
        A[i][C - 1] = A[i - 1][C - 1];
      for (int j = C - 1; j > 1; j--)
        A[Hi][j] = A[Hi][j - 1];
      A[Hi][1] = 0;

    }
    int ans = 0;
    for (int i = 0; i < R; i++)
      for (int j = 0; j < C; j++)
        if (A[i][j] > 0)
          ans += A[i][j];
    log(ans + " ");

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
