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
    int Q[] = new int[20010];
    int head = 10005, tail = 10005;

    int N = Integer.parseInt(br.readLine());
    while (N-- > 0) {
      String op = br.readLine();
      int a;
      if (op.startsWith("push_front")) {
        a = Integer.parseInt(op.substring(11));
        Q[head--] = a;
      } else if (op.startsWith("push_back")) {
        a = Integer.parseInt(op.substring(10));
        Q[++tail] = a;
      } else if (op.startsWith("pop_front"))
        bw.write(head < tail ? Q[++head] + "\n" : "-1\n");
      else if (op.startsWith("pop_back"))
        bw.write(head < tail ? Q[tail--] + "\n" : "-1\n");
      else if (op.startsWith("size"))
        bw.write(tail - head + "\n");
      else if (op.startsWith("empty"))
        bw.write(head == tail ? "1\n" : "0\n");
      else if (op.startsWith("front"))
        bw.write(head < tail ? Q[head + 1] + "\n" : "-1\n");
      else if (op.startsWith("back"))
        bw.write(head < tail ? Q[tail] + "\n" : "-1\n");
    }
    bw.flush();
  }
}
