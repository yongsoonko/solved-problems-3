import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    int dis[][] = new int[N + 1][N + 1], chk[] = new int[N + 1];
    Set<Integer> S[] = new Set[N + 1];

    for (int i = 1; i <= N; i++) {
      S[i] = new HashSet<>();
      Arrays.fill(dis[i], 1, N + 1, (int) 1e9);
      dis[i][i] = 0;
    }

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      dis[a][b] = 1;
      dis[b][a] = 1;
    }

    for (int k = 1; k <= N; k++)
      for (int i = 1; i <= N; i++)
        for (int j = 1; j <= N; j++)
          if (dis[i][j] > dis[i][k] + dis[k][j])
            dis[i][j] = dis[i][k] + dis[k][j];

    for (int i = 1; i <= N; i++)
      for (int j = 1; j <= N; j++)
        if (dis[i][j] < (int) 1e9) {
          S[i].add(j);
          S[j].add(i);
        }

    List<Integer> ans = new ArrayList<>();
    for (int i = 1; i <= N; i++)
      if (chk[i] == 0) {
        int min = (int) 1e9, minIdx = 0;
        for (int j : S[i]) {
          chk[j] = 1;
          int max = 0;
          for (int k : S[j])
            if (max < dis[j][k])
              max = dis[j][k];
          if (min > max) {
            min = max;
            minIdx = j;
          }
        }
        ans.add(minIdx);
      }

    ans.sort(null);
    bw.write(ans.size() + "\n");
    for (int i : ans)
      bw.write(i + "\n");
    bw.flush();

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
