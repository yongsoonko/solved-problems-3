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
  static int N, H, M, A[][], B[];
  static List<Pos> list = new ArrayList<>();

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    A = new int[H + 1][N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      A[a][b] = 1;
    }

    for (int i = 1; i <= H; i++)
      for (int j = 1; j < N; j++)
        if (A[i][j] == 0)
          list.add(new Pos(i, j));
    B = new int[list.size()];

    for (int cnt = 0; cnt <= 3; cnt++) {
      if (dfs(0, 0, cnt)) {
        log(cnt);
        break;
      }
      if (cnt == 3)
        log(-1);
    }

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static boolean dfs(int now, int currCnt, int cnt) {
    if (currCnt == cnt) {
      for (int i = 0; i < cnt; i++) {
        Pos p = list.get(B[i]);
        A[p.i][p.j] = 1;
      }
      for (int i = 1; i <= N; i++) {
        int curr = i;
        for (int j = 0; j <= H; j++) {
          if (curr > 1 && A[j][curr - 1] == 1)
            curr--;
          else if (curr < N && A[j][curr] == 1)
            curr++;
        }
        if (curr != i) {
          for (int j = 0; j < cnt; j++) {
            Pos p = list.get(B[j]);
            A[p.i][p.j] = 0;
          }
          return false;
        }
      }
      return true;
    } else if (now < B.length) {
      B[currCnt] = now;
      if (dfs(now + 1, currCnt + 1, cnt))
        return true;
      if (dfs(now + 1, currCnt, cnt))
        return true;
      return false;
    } else
      return false;
  }
}
