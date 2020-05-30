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
    Deque<Integer> Q = new LinkedList<>();

    int N = Integer.parseInt(br.readLine());
    while (N-- > 0) {
      String op = br.readLine();
      int a;
      if (op.startsWith("push_front")) {
        a = Integer.parseInt(op.substring(11));
        Q.addFirst(a);
      } else if (op.startsWith("push_back")) {
        a = Integer.parseInt(op.substring(10));
        Q.addLast(a);
      } else if (op.startsWith("pop_front"))
        bw.write(Q.isEmpty() ? "-1\n" : Q.removeFirst() + "\n");
      else if (op.startsWith("pop_back"))
        bw.write(Q.isEmpty() ? "-1\n" : Q.removeLast() + "\n");
      else if (op.startsWith("size"))
        bw.write(Q.size() + "\n");
      else if (op.startsWith("empty"))
        bw.write(Q.isEmpty() ? "1\n" : "0\n");
      else if (op.startsWith("front"))
        bw.write(Q.isEmpty() ? "-1\n" : Q.getFirst() + "\n");
      else if (op.startsWith("back"))
        bw.write(Q.isEmpty() ? "-1\n" : Q.getLast() + "\n");
    }
    bw.flush();
  }
}
