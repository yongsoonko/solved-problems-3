import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, M, A[][], ans = (int) 1e9;
  static List<Integer> cctv = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
        if (1 <= A[i][j] && A[i][j] <= 5)
          cctv.add(A[i][j] * 100 + i * 10 + j);
      }
    }

    dfs(0);
    System.out.println(ans);

    // System.out.println("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms");
  }

  static void dfs(int curr) {
    if (curr == cctv.size()) {
      int notChkCnt = 0;
      for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
          if (A[i][j] == 0)
            notChkCnt++;
      if (ans > notChkCnt)
        ans = notChkCnt;
    } else {
      int num = cctv.get(curr) / 100, ci = (cctv.get(curr) / 10) % 10, cj = (cctv.get(curr) % 10);
      int rot = num == 2 ? 2 : num == 5 ? 1 : 4;
      for (int d = 0; d < rot; d++) {
        chk(ci, cj, num, d, -1);
        dfs(curr + 1);
        chk(ci, cj, num, d, 1);
      }
    }
  }

  static void chk(int ci, int cj, int num, int dir, int diff) {
    if (num == 1)
      dirChk(ci, cj, dir, diff);
    else if (num == 2) {
      dirChk(ci, cj, dir, diff);
      dirChk(ci, cj, ((dir + 2) % 4), diff);
    } else if (num == 3) {
      dirChk(ci, cj, dir, diff);
      dirChk(ci, cj, ((dir + 1) % 4), diff);
    } else if (num == 4) {
      dirChk(ci, cj, dir, diff);
      dirChk(ci, cj, ((dir + 1) % 4), diff);
      dirChk(ci, cj, ((dir + 3) % 4), diff);
    } else if (num == 5) {
      dirChk(ci, cj, dir, diff);
      dirChk(ci, cj, ((dir + 1) % 4), diff);
      dirChk(ci, cj, ((dir + 2) % 4), diff);
      dirChk(ci, cj, ((dir + 3) % 4), diff);
    }
  }

  static void dirChk(int ci, int cj, int dir, int diff) {
    int ni = ci + di[dir], nj = cj + dj[dir];
    while (ni >= 0 && ni < N && nj >= 0 && nj < M && A[ni][nj] != 6) {
      if (A[ni][nj] <= 0)
        A[ni][nj] += diff;
      ni = (ci = ni) + di[dir];
      nj = (cj = nj) + dj[dir];
    }
  }
}
