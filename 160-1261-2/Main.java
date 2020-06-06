import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int i;
  int j;
  int k;

  Pos(int i, int j, int k) {
    this.i = i;
    this.j = j;
    this.k = k;
  }

  public int compareTo(Pos p) {
    return k - p.k;
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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int A[][] = new int[N][M];
    int dis[][] = new int[N][M];
    for (int i = 0; i < N; i++) {
      Arrays.fill(dis[i], (int) 1e9);
      String str = br.readLine();
      for (int j = 0; j < M; j++)
        A[i][j] = str.charAt(j) - '0';
    }

    PriorityQueue<Pos> Q = new PriorityQueue<>();
    Q.add(new Pos(0, 0, 0));
    dis[0][0] = 0;

    while (Q.size() > 0) {
      int ci = Q.peek().i, cj = Q.peek().j, ck = Q.peek().k;
      Q.poll();

      if (dis[ci][cj] < ck)
        continue;

      for (int i = 0; i < 4; i++) {
        int ni = ci + di[i], nj = cj + dj[i];
        if (ni >= 0 && ni < N && nj >= 0 && nj < M && dis[ni][nj] > ck + A[ni][nj]) {
          dis[ni][nj] = ck + A[ni][nj];
          Q.add(new Pos(ni, nj, dis[ni][nj]));
        }
      }
    }
    log(dis[N - 1][M - 1]);
  }
}
