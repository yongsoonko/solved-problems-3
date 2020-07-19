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
  static int N, H, M, A[][];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    A = new int[H + 1][N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      A[a][b] = 1;
    }

    for (int cnt = 0; cnt <= 3; cnt++) {
      dfs(1, 1, 0, cnt);
      if (cnt == 3)
        log(-1);
    }

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static void dfs(int ci, int cj, int currCnt, int cnt) {
    if (currCnt == cnt) {
      for (int i = 1; i <= N; i++) {
        int curr = i;
        for (int j = 0; j <= H; j++) {
          if (curr > 1 && A[j][curr - 1] == 1)
            curr--;
          else if (curr < N && A[j][curr] == 1)
            curr++;
        }
        if (curr != i)
          return;
      }
      log(cnt);
      System.exit(0);
    } else {
      for (int i = ci; i <= H; i++)
        for (int j = (i == ci ? cj : 1); j < N; j++)
          if (A[i][j] == 0) {
            if (j > 1 && A[i][j - 1] == 1)
              continue;
            if (j < N - 1 && A[i][j + 1] == 1)
              continue;
            A[i][j] = 1;
            dfs(i, j, currCnt + 1, cnt);
            A[i][j] = 0;
          }
    }
  }
}
