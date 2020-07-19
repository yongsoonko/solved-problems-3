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

  public String toString() {
    return i + " " + j + "\n";
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, A[][], B[], ans = (int) 1e9;
  static List<Integer> list = new ArrayList<>();

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    N = Integer.parseInt(br.readLine());
    A = new int[N][N];
    B = new int[N / 2];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++)
        A[i][j] = Integer.parseInt(st.nextToken());
    }

    dfs(0, 0);
    int p = -1, q = list.size();
    while (++p < --q) {
      int diff = Math.abs(list.get(p) - list.get(q));
      if (ans > diff)
        ans = diff;
    }
    log(ans);
    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static void dfs(int curr, int cnt) {
    if (cnt == N / 2) {
      int sum = 0;
      for (int i = 0; i < B.length; i++)
        for (int j = 0; j < B.length; j++)
          if (i != j)
            sum += A[B[i]][B[j]];
      list.add(sum);
    } else if (curr < N) {
      B[cnt] = curr;
      dfs(curr + 1, cnt + 1);
      dfs(curr + 1, cnt);
    }
  }
}
