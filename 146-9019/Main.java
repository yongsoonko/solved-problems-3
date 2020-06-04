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
    int T = Integer.parseInt(br.readLine());
    String str = "DSLR";

    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());

      int chk[] = new int[10000];
      char chk2[] = new char[10000];
      Arrays.fill(chk, -1);
      Queue<Integer> Q = new LinkedList<>();
      Q.offer(A);
      chk[A] = 1;

      out: while (Q.size() > 0) {
        int sz = Q.size();
        while (sz-- > 0) {
          int curr = Q.poll();
          int d1 = curr / 1000, d4 = curr % 10;
          int J[] = {(curr * 2) % 10000, (curr + 9999) % 10000, (curr - d1 * 1000) * 10 + d1,
              curr / 10 + d4 * 1000};
          for (int dir = 0; dir < 4; dir++) {
            int next = J[dir];
            if (chk[next] == -1) {
              chk[next] = curr;
              chk2[next] = str.charAt(dir);
              Q.offer(next);

              if (next == B)
                break out;
            }
          }
        }
      }

      StringBuilder sb = new StringBuilder();
      while (B != A) {
        sb.insert(0, chk2[B]);
        B = chk[B];
      }
      sb.append('\n');
      bw.write(sb.toString());
    }
    bw.flush();
  }
}
