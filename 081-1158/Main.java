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

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    bw.write('<');
    boolean chk[] = new boolean[N + 1];
    int cnt = 0, kCnt = 0, p = 0;
    while (cnt < N) {
      if (++p == N + 1)
        p = 1;
      if (chk[p])
        continue;
      if (++kCnt % K == 0) {
        chk[p] = true;
        bw.write(++cnt < N ? p + ", " : p + ">");
      }
    }
    bw.flush();
  }
}
