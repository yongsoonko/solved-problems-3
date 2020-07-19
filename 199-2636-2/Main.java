import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, M, A[][], chk[][], cheeseCnt;
  static List<Integer> cheese = new ArrayList<>();

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[N][M];
    chk = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
        if (A[i][j] == 1)
          cheeseCnt++;
      }
    }

    int ans = 0, ansCnt = 0;
    dfs(cheese, 0, 0);
    while (cheeseCnt > 0) {
      List<Integer> tmp = new ArrayList<>();
      for (int curr : cheese) {
        int ci = curr / 101, cj = curr % 101;
        for (int d = 0; d < 4; d++) {
          int ni = ci + di[d], nj = cj + dj[d];
          if (chk[ni][nj] == 0) {
            chk[ni][nj] = 1;
            if (A[ni][nj] == 0)
              dfs(tmp, ni, nj);
            else
              tmp.add(ni * 101 + nj);
          }
        }
      }
      ans++;
      cheeseCnt -= cheese.size();
      ansCnt = cheese.size();
      cheese = tmp;
    }
    log(ans + "\n" + ansCnt);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static void dfs(List<Integer> cheese, int ci, int cj) {
    for (int d = 0; d < 4; d++) {
      int ni = ci + di[d], nj = cj + dj[d];
      if (ni >= 0 && ni < N && nj >= 0 && nj < M && chk[ni][nj] == 0) {
        chk[ni][nj] = 1;
        if (A[ni][nj] == 0)
          dfs(cheese, ni, nj);
        else
          cheese.add(ni * 101 + nj);
      }
    }
  }
}
