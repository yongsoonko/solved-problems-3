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
  static int D[] = new int[10];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    for (int i = 0, num = 1; i < 10; i++, num *= 10)
      D[i] = num;

    int curr = 0;
    for (int i = 0; i < 3; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        int num = Integer.parseInt(st.nextToken());
        if (num == 0)
          num = 9;
        curr = curr * 10 + num;
      }
    }
    int end = 123456789;

    Set<Integer> chk = new HashSet<>();
    Queue<Integer> Q = new LinkedList<>();

    chk.add(curr);
    Q.offer(curr);

    int ans = 0;
    out: while (Q.size() > 0) {
      if (chk.contains(end)) {
        log(ans);
        return;
      }
      ans++;
      int sz = Q.size();
      while (sz-- > 0) {
        curr = Q.poll();
        int zi = 0, zj = 0, num = curr;
        for (int i = 0; i < 9; i++, num /= 10)
          if (num % 10 == 9) {
            zi = i / 3;
            zj = i % 3;
            break;
          }
        int zIdx = zi * 3 + zj;
        for (int i = 0; i < 4; i++) {
          int ni = zi + di[i], nj = zj + dj[i];
          if (ni >= 0 && ni < 3 && nj >= 0 && nj < 3) {
            int next = swap(curr, zIdx, ni * 3 + nj);
            if (chk.add(next)) {
              Q.offer(next);

              if (next == end)
                continue out;
            }
          }
        }
      }
    }
    log(-1);
  }

  static int swap(int a, int i, int j) {
    int d1 = D[i], d2 = D[j];
    int v1 = a / d1 % 10, v2 = a / d2 % 10;
    return a - v1 * d1 + v1 * d2 - v2 * d2 + v2 * d1;
  }
}
