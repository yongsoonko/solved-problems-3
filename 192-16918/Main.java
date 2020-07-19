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
    int N = Integer.parseInt(st.nextToken());
    char A[][] = new char[R][];

    for (int i = 0; i < R; i++)
      A[i] = br.readLine().toCharArray();

    if (N % 2 == 0)
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++)
          bw.write('O');
        bw.write('\n');
      }
    else {
      for (int t = 1; t < N; t += 2) {
        char B[][] = new char[R][C];
        for (int i = 0; i < R; i++)
          for (int j = 0; j < C; j++)
            B[i][j] = 'O';
        for (int i = 0; i < R; i++)
          for (int j = 0; j < C; j++)
            if (A[i][j] == 'O') {
              B[i][j] = '.';
              for (int d = 0; d < 4; d++) {
                int ni = i + di[d], nj = j + dj[d];
                if (ni >= 0 && ni < R && nj >= 0 && nj < C)
                  B[ni][nj] = '.';
              }
            }
        A = B;
      }
      for (char[] a : A) {
        bw.write(a);
        bw.write('\n');
      }
    }
    bw.flush();

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
