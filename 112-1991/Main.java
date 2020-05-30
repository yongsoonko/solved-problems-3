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
  static Pos J[] = new Pos[26];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      int a = str.charAt(2) == '.' ? -1 : str.charAt(2) - 'A';
      int b = str.charAt(4) == '.' ? -1 : str.charAt(4) - 'A';
      J[str.charAt(0) - 'A'] = new Pos(a, b);
    }

    dfs(0, 0);
    bw.write('\n');
    dfs(0, 1);
    bw.write('\n');
    dfs(0, 2);
    bw.flush();
  }

  static void dfs(int curr, int flag) throws IOException {
    if (flag == 0)
      bw.write(curr + 'A');
    if (J[curr].i >= 0)
      dfs(J[curr].i, flag);
    if (flag == 1)
      bw.write(curr + 'A');
    if (J[curr].j >= 0)
      dfs(J[curr].j, flag);
    if (flag == 2)
      bw.write(curr + 'A');
  }
}
