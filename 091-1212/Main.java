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
    bw.write(Integer.toBinaryString(N.charAt(0) - '0'));
    for (int i = 1; i < N.length(); i++) {
      char ch = N.charAt(i);
      char A[] = "000".toCharArray();
      int num = ch - '0', j=2;
      while (num > 0) {
        A[j--] = (char)(num % 2 + '0');
        num /= 2;
      }
      bw.write(A);
    }
    bw.flush();
  }
}
