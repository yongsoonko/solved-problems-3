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
    int N = Integer.parseInt(br.readLine());
    int cnt2 = 0, cnt5 = 0;
    for (int i = 1; i <= N; i++) {
      int num = i;
      while (num % 2 == 0) {
        cnt2++;
        num /= 2;
      }
      while (num % 5 == 0) {
        cnt5++;
        num /= 5;
      }
    }
    log(Math.min(cnt2, cnt5));
  }
}
