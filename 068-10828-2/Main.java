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
    Stack<Integer> S = new Stack<>();
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String op = br.readLine();
      if (op.startsWith("push")) {
        int a = Integer.parseInt(op.substring(5));
        S.push(a);
      } else if (op.startsWith("pop"))
        bw.write(S.isEmpty() ? "-1\n" : S.pop() + "\n");
      else if (op.startsWith("size"))
        bw.write(S.size() + "\n");
      else if (op.startsWith("empty"))
        bw.write(S.isEmpty() ? "1\n" : "0\n");
      else if (op.startsWith("top"))
        bw.write(S.isEmpty() ? "-1\n" : S.peek() + "\n");
    }
    bw.flush();
  }
}
