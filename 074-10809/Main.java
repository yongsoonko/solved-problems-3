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
    int chk[] = new int[26];
    Arrays.fill(chk, -1);

    int i = 0;
    for (char ch : str.toCharArray()) {
      if (chk[ch - 'a'] == -1)
        chk[ch - 'a'] = i;
      i++;
    }

    for (int j : chk)
      bw.write(j + " ");
    bw.flush();
  }
}
