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
    long ab = 0, cd = 0;
    for (char ch : (st.nextToken() + st.nextToken()).toCharArray())
      ab = ab * 10 + ch - '0';
    for (char ch : (st.nextToken() + st.nextToken()).toCharArray())
      cd = cd * 10 + ch - '0';
    log(ab + cd);
  }
}
