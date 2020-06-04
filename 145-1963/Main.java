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
    boolean prime[] = new boolean[10000];

    for (int i = 2; i * i <= 9999; i++)
      if (!prime[i])
        for (int j = i + i; j <= 9999; j += i)
          prime[j] = true;

    int T = Integer.parseInt(br.readLine());
    out: while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int chk[] = new int[10000];

      Queue<Integer> Q = new LinkedList<>();
      Q.offer(A);
      chk[A] = 1;
      int ans = 0;
      while (Q.size() > 0) {
        if (chk[B] == 1) {
          bw.write(ans + "\n");
          continue out;
        }
        ans++;
        int sz = Q.size();
        while (sz-- > 0) {
          int curr = Q.poll();
          for (int d = 1000; d > 0; d /= 10) {
            int tmp = curr - ((curr / d) % 10) * d;
            for (int j = 0; j < 10; j++) {
              if (d == 1000 && j == 0)
                continue;
              int next = tmp + j * d;
              if (chk[next] == 0 && !prime[next]) {
                chk[next] = 1;
                Q.offer(next);
              }
            }
          }
        }
      }
      bw.write("Impossible\n");
    }
    bw.flush();
  }
}
