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
    int K = Integer.parseInt(st.nextToken());
    int dis[] = new int[100001];
    int cnt[] = new int[100001];

    dis[N] = 1;
    cnt[N] = 1;
    Queue<Integer> Q = new LinkedList<>();
    Q.offer(N);

    while (Q.size() > 0) {
      if (dis[K] > 0)
        break;
      int sz = Q.size();
      while (sz-- > 0) {
        int curr = Q.poll();
        int J[] = {curr - 1, curr + 1, curr * 2};
        for (int next : J)
          if (next >= 0 && next <= 100000 && cnt[next] == 0) {
            dis[next] = dis[curr] + 1;
            Q.offer(next);
          }
      }
      sz = Q.size();
      while (sz-- > 0) {
        int next = Q.poll();
        cnt[next]++;
        Q.offer(next);
      }
    }
    log(dis[K] - 1 + "\n");
    log(cnt[K]);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
