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
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    char A[][] = new char[R][];

    Queue<Pos> Q = new LinkedList<>();
    Queue<Pos> Q2 = new LinkedList<>();
    for (int i = 0; i < R; i++) {
      A[i] = br.readLine().toCharArray();
      for (int j = 0; j < C; j++) {
        if (A[i][j] == 'S')
          Q.offer(new Pos(i, j));
        else if (A[i][j] == '*')
          Q2.offer(new Pos(i, j));
      }
    }

    int ans = 0;
    while (Q.size() > 0) {
      ans++;
      int sz = Q2.size();
      while (sz-- > 0) {
        int ci = Q2.peek().i, cj = Q2.peek().j;
        Q2.poll();
        for (int d = 0; d < 4; d++) {
          int ni = ci + di[d], nj = cj + dj[d];
          if (ni >= 0 && ni < R && nj >= 0 && nj < C && A[ni][nj] == '.') {
            A[ni][nj] = '*';
            Q2.offer(new Pos(ni, nj));
          }
        }
      }
      sz = Q.size();
      while (sz-- > 0) {
        int ci = Q.peek().i, cj = Q.peek().j;
        Q.poll();
        for (int d = 0; d < 4; d++) {
          int ni = ci + di[d], nj = cj + dj[d];
          if (ni >= 0 && ni < R && nj >= 0 && nj < C && (A[ni][nj] == '.' || A[ni][nj] == 'D')) {
            if (A[ni][nj] == 'D') {
              log(ans);
              System.exit(0);
            }
            A[ni][nj] = 'S';
            Q.offer(new Pos(ni, nj));
          }
        }
      }
    }
    log("KAKTUS");

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
