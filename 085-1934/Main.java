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

  static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  public static void main(String[] args) throws IOException {
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      bw.write(A * B / gcd(A, B) + "\n");
    }
    bw.flush();
  }
}
