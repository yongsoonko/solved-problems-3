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
    Stack<Integer> S = new Stack<>();
    do {
      if (N % 2 == 0) {
        S.push(0);
        N /= -2;
      } else {
        S.push(1);
        N = (1 - N) / 2;
      }
    } while (N != 0);
    while (S.size() > 0)
      bw.write(S.pop() + '0');
    bw.flush();
  }
}
