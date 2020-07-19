import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int i;
  int j;
  int d;

  Pos(int i, int j, int d) {
    this.i = i;
    this.j = j;
    this.d = d;
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
  static int di[] = {0, 0, 1, -1}, dj[] = {1, -1, 0, 0};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int A[][] = new int[N][M], chk[][][] = new int[N][M][4];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++)
        A[i][j] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    int Si = Integer.parseInt(st.nextToken());
    int Sj = Integer.parseInt(st.nextToken());
    int Sd = Integer.parseInt(st.nextToken());
    Si--;
    Sj--;
    Sd--;

    st = new StringTokenizer(br.readLine());
    int Ei = Integer.parseInt(st.nextToken());
    int Ej = Integer.parseInt(st.nextToken());
    int Ed = Integer.parseInt(st.nextToken());
    Ei--;
    Ej--;
    Ed--;

    chk[Si][Sj][Sd] = 1;
    Queue<Pos> Q = new LinkedList<>();
    Q.offer(new Pos(Si, Sj, Sd));

    int ans = 0;
    while (Q.size() > 0) {
      if (chk[Ei][Ej][Ed] == 1)
        break;
      ans++;
      int sz = Q.size();
      while (sz-- > 0) {
        int ci = Q.peek().i, cj = Q.peek().j, cd = Q.peek().d;
        Q.poll();

        for (int d = 1; d <= 3; d++) {
          int ni = ci + di[cd] * d, nj = cj + dj[cd] * d;
          if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
            if (A[ni][nj] == 0 && chk[ni][nj][cd] == 0) {
              chk[ni][nj][cd] = 1;
              Q.offer(new Pos(ni, nj, cd));
            } else if (A[ni][nj] == 1)
              break;
          }
        }

        for (int d = 0; d < 2; d++) {
          if ((cd == 0 || cd == 1) && chk[ci][cj][2 + d] == 0) {
            chk[ci][cj][2 + d] = 1;
            Q.offer(new Pos(ci, cj, 2 + d));
          } else if ((cd == 2 || cd == 3) && chk[ci][cj][d] == 0) {
            chk[ci][cj][d] = 1;
            Q.offer(new Pos(ci, cj, d));
          }
        }
      }
    }
    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
