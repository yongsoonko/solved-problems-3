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
  static char A[][] = new char[101][];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++)
      A[i] = br.readLine().toCharArray();

    int ans = 1;
    Queue<Pos> Q = new LinkedList<>();
    Q.offer(new Pos(0, 0));
    A[0][0] = '0';

    while (Q.size() > 0) {
      ans++;
      int sz = Q.size();
      while (sz-- > 0) {
        int ci = Q.peek().i, cj = Q.peek().j;
        Q.poll();
        for (int i = 0; i < 4; i++) {
          int ni = ci + di[i], nj = cj + dj[i];
          if (ni >= 0 && ni < N && nj >= 0 && nj < M && A[ni][nj] == '1') {
            A[ni][nj] = '0';
            Q.offer(new Pos(ni, nj));
          }
        }
      }
      if (A[N - 1][M - 1] == '0') {
        log(ans);
        return;
      }
    }
  }
}
