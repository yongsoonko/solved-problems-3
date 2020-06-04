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
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 3; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++)
        sb.append(st.nextToken());
    }
    String end = "123456780";
    
    Set<String> chk = new HashSet<>();
    Queue<String> Q = new LinkedList<>();
    
    chk.add(sb.toString());
    Q.offer(sb.toString());
    
    int ans = 0;
    out: while (Q.size() > 0) {
      if (chk.contains(end)) {
        log(ans);
        return;
      }
      ans++;
      int sz = Q.size();
      while (sz-- > 0) {
        StringBuilder curr = new StringBuilder(Q.poll());
        int zi = 0, zj = 0;
        for (int i = 0; i < 9; i++)
          if (curr.charAt(i) == '0') {
            zi = i / 3;
            zj = i % 3;
            break;
          }
        int zIdx = zi * 3 + zj;
        for (int i = 0; i < 4; i++) {
          int ni = zi + di[i], nj = zj + dj[i];
          if (ni >= 0 && ni < 3 && nj >= 0 && nj < 3) {
            StringBuilder next = new StringBuilder(curr);
            swap(next, zIdx, ni * 3 + nj);
            if (chk.add(next.toString())) {
              Q.offer(next.toString());

              if (next.toString().equals(end))
                continue out;
            }
          }
        }
      }
    }
    log(-1);
  }

  static void swap(StringBuilder sb, int i, int j) {
    char tmp = sb.charAt(i);
    sb.setCharAt(i, sb.charAt(j));
    sb.setCharAt(j, tmp);
  }
}
