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
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    int A[][] = new int[2010][2010];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      x1 = x1 * 2 + 1000;
      y1 = y1 * 2 + 1000;
      x2 = x2 * 2 + 1000;
      y2 = y2 * 2 + 1000;
      for (int j = x1; j <= x2; j++)
        A[j][y1] = A[j][y2] = 1;
      for (int j = y1; j <= y2; j++)
        A[x1][j] = A[x2][j] = 1;
    }

    int ans = A[1000][1000] == 1 ? -1 : 0;
    for (int i = 0; i <= 2000; i++)
      for (int j = 0; j <= 2000; j++)
        if (A[i][j] == 1) {
          ans++;
          A[i][j] = 0;
          Queue<Integer> Q = new LinkedList<>();
          Q.offer(i * 2001 + j);
          while (Q.size() > 0) {
            int ci = Q.peek() / 2001, cj = Q.peek() % 2001;
            Q.poll();
            for (int d = 0; d < 4; d++) {
              int ni = ci + di[d], nj = cj + dj[d];
              if (ni >= 0 && ni <= 2000 && nj >= 0 && nj <= 2000 && A[ni][nj] == 1) {
                A[ni][nj] = 0;
                Q.offer(ni * 2001 + nj);
              }
            }
          }
        }
    log(ans);
  }
}
