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
    PriorityQueue<String> Q = new PriorityQueue<>();
    for (int i = str.length() - 1; i >= 0; i--)
      Q.offer(str.substring(i));
    while (Q.size() > 0)
      bw.write(Q.poll() + "\n");
    bw.flush();
  }
}
