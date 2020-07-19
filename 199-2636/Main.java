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
    int A[][] = new int[N][M], chk[][] = new int[N][M], cheeseCnt = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
        if (A[i][j] == 1)
          cheeseCnt++;
      }
    }

    int ans = 0, ansCnt = 0;
    while (cheeseCnt > 0) {
      for (int i = 0; i < N; i++)
        Arrays.fill(chk[i], 0);

      Queue<Integer> Q = new LinkedList<>();
      Q.offer(0);
      chk[0][0] = 1;

      int cnt = 0;
      while (Q.size() > 0) {
        int ci = Q.peek() / 101, cj = Q.peek() % 101;
        Q.poll();
        for (int d = 0; d < 4; d++) {
          int ni = ci + di[d], nj = cj + dj[d];
          if (ni >= 0 && ni < N && nj >= 0 && nj < M && chk[ni][nj] == 0) {
            chk[ni][nj] = 1;
            if (A[ni][nj] == 0)
              Q.offer(ni * 101 + nj);
            else {
              A[ni][nj] = 0;
              cnt++;
            }
          }
        }
      }
      ans++;
      cheeseCnt -= cnt;
      ansCnt = cnt;
    }

    log(ans + "\n" + ansCnt);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
