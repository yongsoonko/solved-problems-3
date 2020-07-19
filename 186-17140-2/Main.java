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
    return j == p.j ? i - p.i : j - p.j;
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
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int A[][] = new int[101][101];

    for (int i = 1; i <= 3; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= 3; j++)
        A[i][j] = Integer.parseInt(st.nextToken());
    }

    int rLen = 3, cLen = 3;
    for (int ans = 0; ans <= 100; ans++) {
      if (A[r][c] == k) {
        log(ans);
        return;
      }
      int rMax = 0, cMax = 0;
      if (rLen >= cLen) {
        for (int i = 1; i <= rLen; i++) {
          Map<Integer, Integer> M = new HashMap<>();
          for (int j = 1; j <= cLen; j++) {
            if (A[i][j] == 0)
              continue;
            Integer val = M.get(A[i][j]);
            if (val == null)
              M.put(A[i][j], 1);
            else
              M.put(A[i][j], val + 1);
          }
          List<Pos> cnt = new ArrayList<>();
          for (int key : M.keySet())
            cnt.add(new Pos(key, M.get(key)));
          cnt.sort(null);
          int thres = Math.min(50, cnt.size());
          for (int j = 0; j < 50; j++) {
            if (j < thres) {
              A[i][j * 2 + 1] = cnt.get(j).i;
              A[i][j * 2 + 2] = cnt.get(j).j;
            } else
              A[i][j * 2 + 1] = A[i][j * 2 + 2] = 0;
          }
          cMax = Math.max(cMax, thres * 2);
        }
        cLen = cMax;
      } else {
        for (int i = 1; i <= cLen; i++) {
          Map<Integer, Integer> M = new HashMap<>();
          for (int j = 1; j <= rLen; j++) {
            if (A[j][i] == 0)
              continue;
            Integer val = M.get(A[j][i]);
            if (val == null)
              M.put(A[j][i], 1);
            else
              M.put(A[j][i], val + 1);
          }
          List<Pos> cnt = new ArrayList<>();
          for (int key : M.keySet())
            cnt.add(new Pos(key, M.get(key)));
          cnt.sort(null);

          int thres = Math.min(50, cnt.size());
          for (int j = 0; j < 50; j++) {
            if (j < thres) {
              A[j * 2 + 1][i] = cnt.get(j).i;
              A[j * 2 + 2][i] = cnt.get(j).j;
            } else
              A[j * 2 + 1][i] = A[j * 2 + 2][i] = 0;
          }
          rMax = Math.max(rMax, thres * 2);
        }
        rLen = rMax;
      }
    }
    log(-1);
    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
