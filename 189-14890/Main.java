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
    int L = Integer.parseInt(st.nextToken());
    int A[][] = new int[N][N], chk[][][] = new int[N][N][2];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++)
        A[i][j] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    out: for (int i = 0; i < N; i++) {
      for (int j = 0; j < N - 1; j++) {
        int diff = A[i][j] - A[i][j + 1];
        if (diff >= 2 || diff <= -2)
          continue out;
        else if (diff == 1) {
          for (int k = j + 1; k <= j + L; k++) {
            if (k >= N || chk[i][k][0] == 1 || A[i][j + 1] != A[i][k])
              continue out;
            chk[i][k][0] = 1;
          }
        } else if (diff == -1) {
          for (int k = j; k > j - L; k--) {
            if (k < 0 || chk[i][k][0] == 1 || A[i][j] != A[i][k])
              continue out;
            chk[i][k][0] = 1;
          }
        }
      }
      ans++;
    }

    out: for (int j = 0; j < N; j++) {
      for (int i = 0; i < N - 1; i++) {
        int diff = A[i][j] - A[i + 1][j];
        if (diff >= 2 || diff <= -2)
          continue out;
        else if (diff == 1) {
          for (int k = i + 1; k <= i + L; k++) {
            if (k >= N || chk[k][j][1] == 1 || A[i + 1][j] != A[k][j])
              continue out;
            chk[k][j][1] = 1;
          }
        } else if (diff == -1) {
          for (int k = i; k > i - L; k--) {
            if (k < 0 || chk[k][j][1] == 1 || A[i][j] != A[k][j])
              continue out;
            chk[k][j][1] = 1;
          }
        }
      }
      ans++;
    }

    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
