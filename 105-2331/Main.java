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
  static List<List<Integer>> J = new ArrayList<>();
  static int dis[] = new int[300000];
  static int P;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());

    dis[A] = 1;
    log(dfs(A));
  }

  static int dfs(int curr) {
    int next = 0, num = curr;
    do
      next += Math.pow((num % 10), P);
    while ((num /= 10) > 0);
    if (dis[next] > 0)
      return dis[next] - 1;
    else {
      dis[next] = dis[curr] + 1;
      return dfs(next);
    }
  }
}
