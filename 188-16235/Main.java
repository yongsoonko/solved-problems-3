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
  static int di[] = {-1, -1, 0, 1, 1, 1, 0, -1}, dj[] = {0, 1, 1, 1, 0, -1, -1, -1};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int A[][] = new int[N][N], E[][] = new int[N][N];
    PriorityQueue<Integer> T[][] = new PriorityQueue[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
        E[i][j] = 5;
        T[i][j] = new PriorityQueue<>();
      }
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken()) - 1;
      int c = Integer.parseInt(st.nextToken()) - 1;
      int k = Integer.parseInt(st.nextToken());
      T[r][c].offer(k);
    }

    int tmp2[][] = new int[N][N];
    for (int year = 0; year < K; year++) {
      for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++) {
          int dead = 0;
          PriorityQueue<Integer> tmp = new PriorityQueue<>();
          while (T[i][j].size() > 0) {
            int curr = T[i][j].poll();
            if (E[i][j] >= curr) {
              E[i][j] -= curr;
              tmp.offer(curr + 1);
              if ((curr + 1) % 5 == 0) {
                for (int d = 0; d < 8; d++) {
                  int ni = i + di[d], nj = j + dj[d];
                  if (ni >= 0 && ni < N && nj >= 0 && nj < N)
                    tmp2[ni][nj]++;
                }
              }
            } else
              dead += (curr / 2);
          }
          T[i][j] = tmp;
          E[i][j] += (dead + A[i][j]);

        }
      for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
          while (tmp2[i][j] > 0) {
            T[i][j].offer(1);
            tmp2[i][j]--;
          }
    }

    int ans = 0;
    for (int i = 0; i < N; i++) 
      for (int j = 0; j < N; j++) 
        ans += T[i][j].size();

    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
