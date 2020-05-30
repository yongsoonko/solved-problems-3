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
    int cnt[] = new int[10001];
    for (int i = 0; i < N; i++)
      cnt[Short.parseShort(br.readLine())]++;

    for (int i = 1; i <= 10000; i++)
      while (cnt[i]-- > 0)
        bw.write(i + "\n");
    bw.flush();
  }
}
