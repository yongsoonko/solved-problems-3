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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int F = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int G = Integer.parseInt(st.nextToken());
    int U = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());

    int chk[] = new int[F + 1];
    chk[S] = 1;

    Queue<Integer> Q = new LinkedList<>();
    Q.offer(S);

    int ans = 0;
    while (Q.size() > 0) {
      if (chk[G] == 1) {
        log(ans);
        return;
      }
      ans++;
      int sz = Q.size();
      while (sz-- > 0) {
        int curr = Q.poll();
        if (curr + U <= F && chk[curr + U] == 0) {
          chk[curr + U] = 1;
          Q.offer(curr + U);
        }
        if (curr - D >= 1 && chk[curr - D] == 0) {
          chk[curr - D] = 1;
          Q.offer(curr - D);
        }
      }
    }
    log("use the stairs");
  }
}
