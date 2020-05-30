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
  static int di[] = {1, 1, 0, -1, -1, -1, 0, 1}, dj[] = {0, 1, 1, 1, 0, -1, -1, -1};
  static int A[][] = new int[51][51];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    String str;
    while ((str = br.readLine()).charAt(0) != '0') {
      StringTokenizer st = new StringTokenizer(str);
      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());

      for (int i = 0; i < h; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < w; j++)
          A[i][j] = Integer.parseInt(st.nextToken());
      }

      Queue<Integer> Q = new LinkedList<>();
      int ans = 0;
      for (int i = 0; i < h; i++)
        for (int j = 0; j < w; j++)
          if (A[i][j] == 1) {
            ans++;
            A[i][j] = 0;
            Q.offer(i * 51 + j);
            while (Q.size() > 0) {
              int ci = Q.peek() / 51, cj = Q.peek() % 51;
              Q.poll();
              for (int k = 0; k < 8; k++) {
                int ni = ci + di[k], nj = cj + dj[k];
                if (ni >= 0 && ni < h && nj >= 0 && nj < w && A[ni][nj] == 1) {
                  A[ni][nj] = 0;
                  Q.offer(ni * 51 + nj);
                }
              }
            }
          }
      bw.write(ans + "\n");
    }
    bw.flush();
  }
}
