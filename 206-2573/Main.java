import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int A[][] = new int[N][M], B[][] = new int[N][M], chk[][];
    List<Integer> ice = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
        if (A[i][j] > 0)
          ice.add(i * 301 + j);
      }
    }

    int ans = 0;
    while (ice.size() > 0) {
      chk = new int[N][M];
      int ci = ice.get(0) / 301, cj = ice.get(0) % 301;
      chk[ci][cj] = 1;
      Queue<Integer> Q = new LinkedList<>();
      Q.offer(ice.get(0));
      int cnt = 0;

      while (Q.size() > 0) {
        ci = Q.peek() / 301;
        cj = Q.peek() % 301;
        Q.poll();
        cnt++;
        for (int d = 0; d < 4; d++) {
          int ni = ci + di[d], nj = cj + dj[d];
          if (A[ni][nj] > 0 && chk[ni][nj] == 0) {
            chk[ni][nj] = 1;
            Q.offer(ni * 301 + nj);
          }
        }
      }
      if (cnt < ice.size()) {
        log(ans);
        return;
      }

      for (int curr : ice) {
        ci = curr / 301;
        cj = curr % 301;
        for (int d = 0; d < 4; d++) {
          int ni = ci + di[d], nj = cj + dj[d];
          if (A[ni][nj] == 0)
            B[ci][cj]++;
        }
      }
      List<Integer> tmp = new ArrayList<>();
      for (int curr : ice) {
        ci = curr / 301;
        cj = curr % 301;
        A[ci][cj] = Math.max(0, A[ci][cj] - B[ci][cj]);
        B[ci][cj] = 0;
        if (A[ci][cj] > 0)
          tmp.add(ci * 301 + cj);
      }
      ice = tmp;
    }

    log(0);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
