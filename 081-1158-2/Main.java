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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    bw.write('<');
    int Q[] = new int[30000000];
    int head = -1, tail = -1;
    for (int i = 1; i <= N; i++)
      Q[++tail] = i;
    int cnt = 0, kCnt = 0;
    while (head < tail) {
      if (++kCnt % K == 0)
        bw.write(++cnt < N ? Q[++head] + ", " : Q[++head] + ">");
      else
        Q[++tail] = Q[++head];
    }
    bw.flush();
  }
}
