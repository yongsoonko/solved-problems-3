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
    String str = br.readLine();
    for (char ch : str.toCharArray()) {
      if (ch >= 'a' && ch <= 'z')
        bw.write('a' + (ch + 13 - 'a') % 26);
      else if (ch >= 'A' && ch <= 'Z')
        bw.write('A' + (ch + 13 - 'A') % 26);
      else
        bw.write(ch);
    }
    bw.flush();
  }
}
