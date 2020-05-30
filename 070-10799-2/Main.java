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
    char str[] = br.readLine().toCharArray();
    int p = 1, q = 0, ans = 0;
    while (++q < str.length) {
      if (str[q] == '(')
        p++;
      else {
        if (str[q - 1] == '(')
          ans += --p;
        else {
          p--;
          ans++;
        }
      }
    }
    log(ans);
  }
}
