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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int dis[][] = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      Arrays.fill(dis[i], 1, N + 1, (int) 1e9);
      dis[i][i] = 0;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      dis[a][b] = 1;
    }

    for (int k = 1; k <= N; k++)
      for (int i = 1; i <= N; i++)
        for (int j = 1; j <= N; j++)
          if (dis[i][j] > dis[i][k] + dis[k][j])
            dis[i][j] = dis[i][k] + dis[k][j];

    int ans = 0;
    for (int i = 1; i <= N; i++) {
      int sum = 0;
      for (int j = 1; j <= N; j++)
        if (dis[i][j] < (int) 1e9 || dis[j][i] < (int) 1e9)
          sum++;
      if (sum == N)
        ans++;
    }
    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
