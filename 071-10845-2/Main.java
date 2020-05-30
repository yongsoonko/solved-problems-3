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
    Queue<Integer> Q = new LinkedList<>();
    int N = Integer.parseInt(br.readLine());
    while (N-- > 0) {
      String op = br.readLine();
      if (op.startsWith("push")) {
        int a = Integer.parseInt(op.substring(5));
        Q.offer(a);
      } else if (op.startsWith("pop"))
        bw.write(Q.isEmpty() ? "-1\n" : Q.poll() + "\n");
      else if (op.startsWith("size"))
        bw.write(Q.size() + "\n");
      else if (op.startsWith("empty"))
        bw.write(Q.isEmpty() ? "1\n" : "0\n");
      else if (op.startsWith("front"))
        bw.write(Q.isEmpty() ? "-1\n" : Q.peek() + "\n");
      else if (op.startsWith("back"))
        bw.write(Q.isEmpty() ? "-1\n" : +((LinkedList<Integer>) Q).getLast() + "\n");
    }
    bw.flush();
  }
}
