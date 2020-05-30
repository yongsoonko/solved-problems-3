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
    String str;
    while ((str = br.readLine()) != null) {
      int i = 0, j = 0, k = 0, l = 0;
      for (char ch : str.toCharArray()) {
        if (ch >= 'a' && ch <= 'z')
          i++;
        else if (ch >= 'A' && ch <= 'Z')
          j++;
        else if (ch >= '0' && ch <= '9')
          k++;
        else
          l++;
      }
      bw.write(i + " " + j + " " + k + " " + l + "\n");
    }
    bw.flush();
  }
}
