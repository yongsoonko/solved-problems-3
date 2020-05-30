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
  static char A[][];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    A = new char[N][N];

    for (int i = 0; i < N; i++)
      A[i] = br.readLine().toCharArray();

    log(dfs(0, 0, N));
  }

  static String dfs(int ci, int cj, int size) {
    if (size == 1)
      return String.valueOf(A[ci][cj]);

    int cnt[] = new int[3];
    StringBuilder sb = new StringBuilder();
    size /= 2;
    for (int i = 0; i < 2; i++)
      for (int j = 0; j < 2; j++) {
        String str = dfs(ci + size * i, cj + size * j, size);
        sb.append(str);
        if (str.length() == 1)
          cnt[str.charAt(0) - '0']++;
      }

    if (cnt[0] == 4)
      return "0";
    if (cnt[1] == 4)
      return "1";

    return "(" + sb.toString() + ")";
  }
}
