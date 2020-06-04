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
  static int K, S[], ans[] = new int[6];;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    String str;
    while ((str = br.readLine()).charAt(0) != '0') {
      StringTokenizer st = new StringTokenizer(str);
      K = Integer.parseInt(st.nextToken());
      S = new int[K];
      for (int i = 0; i < K; i++)
        S[i] = Integer.parseInt(st.nextToken());

      dfs(0, 0);
      bw.write('\n');
    }
    bw.flush();
  }

  static void dfs(int curr, int cnt) throws IOException {
    if (cnt == 6) {
      for (int i : ans)
        bw.write(i + " ");
      bw.write('\n');
    } else if (curr < K) {
      ans[cnt] = S[curr];
      dfs(curr + 1, cnt + 1);
      dfs(curr + 1, cnt);
    }
  }
}
