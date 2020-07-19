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

  public String toString() {
    return i + " " + j + "\n";
  }
}


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
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    char A[][] = new char[N][];

    for (int i = 0; i < N; i++)
      A[i] = br.readLine().toCharArray();

    for (int i = 0; i < N; i++)
      for (int j = 0; j < M; j++)
        if (A[i][j] == 'S') {
          for (int d = 0; d < 4; d++) {
            int ni = i + di[d], nj = j + dj[d];
            if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
              if (A[ni][nj] == 'W') {
                log(0);
                return;
              } else if (A[ni][nj] == '.')
                A[ni][nj] = 'D';
            }
          }
        }
    bw.write(1 + "\n");
    for (char[] a : A) {
      bw.write(a);
      bw.write('\n');
    }
    bw.flush();

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
