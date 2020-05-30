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
  static int cnt2 = 0, cnt5 = 0;

  static void log(Object o) {
    System.out.print(o);
  }

  static void getCnt(int n, int sign) {
    long div2 = 1, div5 = 1;
    while (n >= (div2 *= 2))
      cnt2 += n / div2 * sign;
    while (n >= (div5 *= 5))
      cnt5 += n / div5 * sign;
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    getCnt(n, 1);
    getCnt(n - m, -1);
    getCnt(m, -1);

    log(Math.min(cnt2, cnt5));
  }
}
