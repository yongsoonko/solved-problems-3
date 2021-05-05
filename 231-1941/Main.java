import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int A[][] = new int[5][5], chk[][] = new int[5][5], union[] = new int[7];
  static int ans, yCnt;
  static Set<Integer> stateChk = new HashSet<>();

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();

    for (int i = 0; i < 5; i++) {
      char tmp[] = br.readLine().toCharArray();
      for (int j = 0; j < 5; j++)
        A[i][j] = tmp[j] == 'Y' ? 0 : 1;
    }

    for (int i = 0; i < 5; i++)
      for (int j = 0; j < 5; j++) {
        chk[i][j] = 1;
        union[0] = i * 10 + j;
        dfs((1 << (i * 5 + j)), 0, A[i][j] == 0 ? 1 : 0);
        chk[i][j] = 0;
      }

    System.out.println(ans);

    // System.out.println("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms");
  }

  static void dfs(int state, int dth, int yCnt) {
    if (stateChk.contains(state | (dth << 25)))
      return;
    else if (dth == 6)
      ans++;
    else {
      for (int i = 0; i <= dth; i++) {
        int ui = union[i] / 10, uj = union[i] % 10;
        for (int d = 0; d < 4; d++) {
          int ni = ui + di[d], nj = uj + dj[d];
          if (ni >= 0 && ni < 5 && nj >= 0 && nj < 5 && chk[ni][nj] == 0
              && (yCnt < 3 || yCnt == 3 && A[ni][nj] == 1)) {
            chk[ni][nj] = 1;
            union[dth + 1] = ni * 10 + nj;
            dfs(state + (1 << ((ni * 5) + nj)), dth + 1, yCnt + (A[ni][nj] == 0 ? 1 : 0));
            chk[ni][nj] = 0;
          }
        }
      }
    }
    stateChk.add(state | (dth << 25));
  }
}
