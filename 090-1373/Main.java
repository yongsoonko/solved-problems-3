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
    int num = 0, i, cnt = 0;
    for (i = 0; i < N.length() % 3; i++)
      num = num * 2 + N.charAt(i) - '0';
    if (N.length() % 3 != 0)
      bw.write(num + '0');
    num = 0;
    while (i < N.length()) {
      num = num * 2 + N.charAt(i) - '0';
      if (++cnt % 3 == 0) {
        bw.write(num + '0');
        num = 0;
      }
      i++;
    }
    bw.flush();
  }
}
