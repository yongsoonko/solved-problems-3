import java.io.*;
import java.util.*;

class Pos {
  int i;
  int sum;
  int cnt;
  int h;

  Pos(int i, int sum) {
    this.i = i;
    this.sum = sum;
    h = cnt = 1;
  }

  @Override
  public String toString() {
    return i + " " + sum + " " + cnt + '\t';
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, L, R, A[][], flag;
  static Pos T[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    A = new int[N][N];
    T = new Pos[51 * 51];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++)
        A[i][j] = Integer.parseInt(st.nextToken());
    }

    int ans;
    for (ans = 0; ans <= 2000; ans++) {
      flag = 0;
      for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
          T[i * 51 + j] = new Pos(-1, A[i][j]);
      for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
          for (int d = 1; d <= 2; d++) {
            int ni = i + di[d], nj = j + dj[d];
            if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
              int diff = Math.abs(A[i][j] - A[ni][nj]);
              if (L <= diff && diff <= R) {
                flag = 1;
                merge(i * 51 + j, ni * 51 + nj);
              }
            }
          }

      for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++) {
          Pos tmp = T[find(i * 51 + j)];
          int avg = tmp.sum / tmp.cnt;
          A[i][j] = avg;
        }

      if (flag == 0)
        break;
    }
    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static int find(int x) {
    if (T[x].i == -1)
      return x;
    return T[x].i = find(T[x].i);
  }

  static void merge(int x, int y) {
    x = find(x);
    y = find(y);
    if (x != y) {
      if (T[x].h > T[y].h) {
        T[y].i = x;
        T[x].sum += T[y].sum;
        T[x].cnt += T[y].cnt;
      } else if (T[x].h <= T[y].h) {
        T[x].i = y;
        T[y].sum += T[x].sum;
        T[y].cnt += T[x].cnt;
        if (T[x].h == T[y].h)
          T[y].h++;
      }
    }
  }
}
