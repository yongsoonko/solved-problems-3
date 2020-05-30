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
    int S[] = new int[10001];
    int idx = -1;
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String op = br.readLine();
      if (op.startsWith("push")) {
        int a = Integer.parseInt(op.substring(5));
        S[++idx] = a;
      } else if (op.startsWith("pop"))
        bw.write(idx < 0 ? "-1\n" : S[idx--] + "\n");
      else if (op.startsWith("size"))
        bw.write((idx + 1) + "\n");
      else if (op.startsWith("empty"))
        bw.write(idx < 0 ? "1\n" : "0\n");
      else if (op.startsWith("top"))
        bw.write(idx < 0 ? "-1\n" : S[idx] + "\n");
    }
    bw.flush();
  }
}
