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

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int A[][] = new int[M][N];

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      for (int j = x1; j < x2; j++)
        for (int k = y1; k < y2; k++)
          A[j][k] = 1;
    }

    List<Integer> ans = new ArrayList<>();
    Queue<Pos> Q = new LinkedList<>();
    for (int i = 0; i < M; i++)
      for (int j = 0; j < N; j++)
        if (A[i][j] == 0) {
          int sum = 0;
          A[i][j] = 1;
          Q.offer(new Pos(i, j));
          while (Q.size() > 0) {
            int ci = Q.peek().i, cj = Q.peek().j;
            Q.poll();
            sum++;
            for (int d = 0; d < 4; d++) {
              int ni = ci + di[d], nj = cj + dj[d];
              if (ni >= 0 && ni < M && nj >= 0 && nj < N && A[ni][nj] == 0) {
                A[ni][nj] = 1;
                Q.offer(new Pos(ni, nj));
              }
            }
          }
          ans.add(sum);
        }

    bw.write(ans.size() + "\n");
    ans.sort(null);
    for (int i : ans)
      bw.write(i + " ");
    bw.flush();

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
