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
    LinkedList<Integer> T[][] = new LinkedList[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
        E[i][j] = 5;
        T[i][j] = new LinkedList<>();
      }
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken()) - 1;
      int c = Integer.parseInt(st.nextToken()) - 1;
      int k = Integer.parseInt(st.nextToken());
      T[r][c].add(k);
    }

    // LinkedList<Integer> test = new LinkedList<>();
    // test.add(1);
    // test.add(2);
    // test.add(3);
    // test.add(4);
    // test.add(5);
    // ListIterator<Integer> lt = test.listIterator();
    // lt.add(0);
    // while (lt.hasNext()) {
    // log(lt.next() + " ");
    // }
    // System.exit(0);

    int tmp2[][] = new int[N][N];
    for (int year = 0; year < K; year++) {
      for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++) {
          int dead = 0;
          ListIterator<Integer> it = T[i][j].listIterator();
          while (it.hasNext()) {
            int curr = it.next();
            if (E[i][j] >= curr) {
              E[i][j] -= curr;
              it.set(curr + 1);
              if ((curr + 1) % 5 == 0) {
                for (int d = 0; d < 8; d++) {
                  int ni = i + di[d], nj = j + dj[d];
                  if (ni >= 0 && ni < N && nj >= 0 && nj < N)
                    tmp2[ni][nj]++;
                }
              }
            } else {
              it.remove();
              dead += (curr / 2);
            }
          }
          E[i][j] += (dead + A[i][j]);
        }
      for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
          while (tmp2[i][j] > 0) {
            T[i][j].addFirst(1);
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
