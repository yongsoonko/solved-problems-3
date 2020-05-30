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

  static long gcd(long a, long b) {
    return b == 0L ? a : gcd(b, a % b);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());
    for (long i = gcd(A, B); i > 0; i--)
      bw.write('1');
    bw.flush();
  }
}
