import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int i, j;

  Pos(int i, int j) {
    this.i = i;
    this.j = j;
  }

  public int compareTo(Pos p) {
    return j == p.j ? i - p.i : j - p.j;
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
    PriorityQueue<Pos> Q = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      Q.offer(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    while (Q.size() > 0) {
      Pos p = Q.poll();
      bw.write(p.i + " " + p.j + "\n");
    }
    bw.flush();
  }
}
