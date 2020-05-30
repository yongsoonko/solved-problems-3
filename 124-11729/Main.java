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
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static StringBuilder sb = new StringBuilder();
  static int cnt;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    dfs(N, 1, 2, 3);
    log(cnt + "\n" + sb);
  }

  static void dfs(int size, int from, int tmp, int to) {
    if (size == 0)
      return;
    dfs(size - 1, from, to, tmp);
    sb.append(from).append(' ').append(to).append('\n');
    cnt++;
    dfs(size - 1, tmp, from, to);
  }
}
