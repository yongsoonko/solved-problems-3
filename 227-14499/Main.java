import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int dx[] = {0, 0, -1, 1}, dy[] = {1, -1, 0, 0};
  static int N, M, x, y, K, A[][], cmd[], dice[] = new int[6];

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    A = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++)
        A[i][j] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    cmd = new int[K];
    for (int i = 0; i < K; i++)
      cmd[i] = Integer.parseInt(st.nextToken()) - 1;

    for (int dir : cmd) {
      int nx = x + dx[dir], ny = y + dy[dir];
      if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
        if (dir == 0)
          right();
        else if (dir == 1)
          left();
        else if (dir == 2)
          up();
        else if (dir == 3)
          down();

        if (A[nx][ny] == 0)
          A[nx][ny] = dice[3];
        else {
          dice[3] = A[nx][ny];
          A[nx][ny] = 0;
        }

        bw.write(dice[1] + "\n");

        x = nx;
        y = ny;
      }
    }
    bw.flush();

    // System.out.println("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms");
  }

  static void up() {
    int tmp = dice[0];
    for (int i = 0; i < 3; i++)
      dice[i] = dice[i + 1];
    dice[3] = tmp;
  }

  static void down() {
    int tmp = dice[3];
    for (int i = 3; i > 0; i--)
      dice[i] = dice[i - 1];
    dice[0] = tmp;
  }

  static void right() {
    int tmp = dice[4];
    dice[4] = dice[3];
    dice[3] = dice[5];
    dice[5] = dice[1];
    dice[1] = tmp;
  }

  static void left() {
    int tmp = dice[5];
    dice[5] = dice[3];
    dice[3] = dice[4];
    dice[4] = dice[1];
    dice[1] = tmp;
  }
}
