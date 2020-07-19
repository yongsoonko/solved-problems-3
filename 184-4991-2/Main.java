import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

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
    String str;
    while ((str = br.readLine()).charAt(0) != '0') {
      StringTokenizer st = new StringTokenizer(str);
      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());
      char A[][] = new char[h][];

      List<Pos> D = new ArrayList<>();
      Pos o = null;
      for (int i = 0; i < h; i++) {
        A[i] = br.readLine().toCharArray();
        for (int j = 0; j < w; j++)
          if (A[i][j] == 'o') {
            o = new Pos(i, j);
            A[i][j] = '*';
          } else if (A[i][j] == '*')
            D.add(new Pos(i, j));
      }
      D.add(0, o);

      int dis[][] = new int[D.size()][D.size()];
      for (int i = 0; i < D.size(); i++) {
        Arrays.fill(dis[i], (int) 1e9);
        Pos curr = D.get(i);
        int chk[][] = new int[h][w];
        Queue<Pos> Q = new LinkedList<>();
        chk[curr.i][curr.j] = 1;
        Q.offer(curr);

        int cnt = 0, step = 0;
        while (Q.size() > 0) {
          if (cnt == D.size())
            break;
          step++;
          int sz = Q.size();
          while (sz-- > 0) {
            int ci = Q.peek().i, cj = Q.peek().j;
            Q.poll();
            for (int d = 0; d < 4; d++) {
              int ni = ci + di[d], nj = cj + dj[d];
              if (ni >= 0 && ni < h && nj >= 0 && nj < w && A[ni][nj] != 'x' && chk[ni][nj] == 0) {
                if (A[ni][nj] == '*') {
                  for (int j = 0; j < D.size(); j++)
                    if (ni == D.get(j).i && nj == D.get(j).j) {
                      dis[i][j] = step;
                      break;
                    }
                  cnt++;
                }
                chk[ni][nj] = 1;
                Q.offer(new Pos(ni, nj));
              }
            }
          }
        }
      }

      int seq[] = IntStream.range(0, D.size()).toArray(), ans = (int) 1e9;
      out: do {
        int sum = 0;
        for (int i = 1; i < D.size(); i++) {
          if (dis[seq[i - 1]][seq[i]] == (int) 1e9) {
            ans = (int) 1e9;
            break out;
          }
          sum += dis[seq[i - 1]][seq[i]];
        }
        if (ans > sum)
          ans = sum;
      } while (next_permutation(seq, 1, D.size()));
      bw.write(ans == (int) 1e9 ? "-1\n" : ans + "\n");
    }
    bw.flush();
    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static boolean next_permutation(int A[], int lt, int rt) {
    int pv = lt;
    for (int i = 1; i < rt; i++)
      if (A[i - 1] < A[i])
        pv = i;

    if (pv == lt)
      return false;

    for (int i = rt - 1; i >= pv; i--)
      if (A[pv - 1] < A[i]) {
        swap(A, pv - 1, i);
        break;
      }

    int p = pv, q = rt - 1;
    while (p < q)
      swap(A, p++, q--);

    return true;
  }

  static void swap(int A[], int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
  }
}
