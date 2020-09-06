import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, M, A[][], pClosedSize, ans = (int) 1e9;
  static List<Integer> house = new ArrayList<Integer>(), pizza = new ArrayList<Integer>();

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
        if (A[i][j] == 1)
          house.add(i * 100 + j);
        else if (A[i][j] == 2)
          pizza.add(i * 100 + j);
      }
    }

    pClosedSize = pizza.size() - M;
    dfs(0, 0);

    System.out.println(ans);

    // System.out.println("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms");
  }

  static void dfs(int dth, int curr) {
    if (dth == pClosedSize) {
      int disSum = 0;
      for (int hPos : house) {
        int disMin = (int) 1e9;
        int hi = hPos / 100, hj = hPos % 100;
        for (int pPos : pizza) {
          int pi = pPos / 100, pj = pPos % 100;
          int dis = Math.abs(hi - pi) + Math.abs(hj - pj);
          if (disMin > dis)
            disMin = dis;
        }
        disSum += disMin;
      }
      if (ans > disSum)
        ans = disSum;
    } else if (curr < pizza.size()) {
      dfs(dth, curr + 1);
      int pos = pizza.remove(curr);
      dfs(dth + 1, curr);
      pizza.add(curr, pos);
    }
  }
}
