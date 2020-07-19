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
    int dis[][] = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      Arrays.fill(dis[i], 1, N + 1, (int) 1e9);
      dis[i][i] = 0;
    }

    String str;
    while ((str = br.readLine()).charAt(0) != '-') {
      StringTokenizer st = new StringTokenizer(str);
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

    int min = (int) 1e9;
    List<Integer> ans = null;
    for (int i = 1; i <= N; i++) {
      int max = 0;
      for (int j = 1; j <= N; j++)
        if (max < dis[i][j])
          max = dis[i][j];
      if (min > max) {
        min = max;
        ans = new ArrayList<>();
        ans.add(i);
      } else if (min == max)
        ans.add(i);
    }
    bw.write(min + " " + ans.size() + "\n");
    for (int i : ans)
      bw.write(i + " ");
    bw.flush();

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
