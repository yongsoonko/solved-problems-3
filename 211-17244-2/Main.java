import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Pos /* implements Comparable<Pos> */ {
  int i, j;

  public Pos(int i, int j) {
    this.i = i;
    this.j = j;
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
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    char A[][] = new char[N][];
    int chk[][], dis[][];
    Pos E = null;

    List<Pos> X = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      A[i] = br.readLine().toCharArray();
      for (int j = 0; j < M; j++) {
        if (A[i][j] == 'S') {
          X.add(0, new Pos(i, j));
          A[i][j] = 'X';
        } else if (A[i][j] == 'X')
          X.add(new Pos(i, j));
        else if (A[i][j] == 'E') {
          E = new Pos(i, j);
          A[i][j] = 'X';
        }
      }
    }
    X.add(E);

    dis = new int[X.size()][X.size()];
    for (int i = 0; i < X.size(); i++) {
      Arrays.fill(dis[i], (int) 1e9);
      dis[i][i] = 0;
    }

    out: for (int i = 0; i < X.size(); i++) {
      Queue<Pos> Q = new LinkedList<>();
      int cnt = 1;
      chk = new int[N][M];
      chk[X.get(i).i][X.get(i).j] = 1;
      Q.offer(X.get(i));

      int disCnt = 0;
      while (Q.size() > 0) {
        disCnt++;
        int sz = Q.size();
        while (sz-- > 0) {
          int ci = Q.peek().i, cj = Q.peek().j;
          Q.poll();
          for (int d = 0; d < 4; d++) {
            int ni = ci + di[d], nj = cj + dj[d];
            if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
              if (A[ni][nj] == '.' && chk[ni][nj] == 0) {
                chk[ni][nj] = 1;
                Q.offer(new Pos(ni, nj));
              } else if (A[ni][nj] == 'X' && chk[ni][nj] == 0) {
                chk[ni][nj] = 1;
                int j;
                for (j = 0; j < X.size(); j++)
                  if (ni == X.get(j).i && nj == X.get(j).j)
                    break;
                dis[i][j] = disCnt;
                if (++cnt == X.size())
                  continue out;
                Q.offer(new Pos(ni, nj));
              }
            }
          }
        }
      }
    }

    int seq[] = IntStream.range(0, X.size()).toArray();
    int ans = (int) 1e9;
    if (X.size() == 2)
      log(dis[0][1]);
    else {
      do {
        int sum = 0;
        for (int i = 1; i < X.size(); i++)
          sum += dis[seq[i - 1]][seq[i]];
        if (ans > sum)
          ans = sum;
      } while (next_permutation(seq, 1, X.size() - 2));
      log(ans);
    }

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static boolean next_permutation(int A[], int lt, int rt) {
    int pv = lt;
    for (int i = 1; i <= rt; i++)
      if (A[i - 1] < A[i])
        pv = i;

    if (pv == lt)
      return false;

    for (int i = rt; i >= pv; i--)
      if (A[pv - 1] < A[i]) {
        swap(A, pv - 1, i);
        break;
      }

    int p = pv, q = rt;
    while (p < q)
      swap(A, p++, q--);

    return true;
  }

  static void swap(int A[], int lt, int rt) {
    int tmp = A[lt];
    A[lt] = A[rt];
    A[rt] = tmp;
  }
}
