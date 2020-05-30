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
    String N = br.readLine();
    int num = 0, cnt = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = N.length() - 1; i >= 0; i--) {
      num += (N.charAt(i) - '0') << ++cnt - 1;
      if (cnt == 3) {
        sb.append(num);
        num = cnt = 0;
      }
    }
    if (cnt > 0)
      sb.append(num);
    log(sb.reverse());
  }
}
