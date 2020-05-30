import java.io.*;
import java.util.*;

class Pos {
  int i, j;

  Pos(int i, int j) {
    this.i = i;
    this.j = j;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    int[][] cnt = new int[2][10];
    Arrays.fill(cnt[0], 1);
    cnt[0][0] = 0;

    int curr = 0, next = 1;
    for (int i = 2; i <= N; i++) {
      for (int j = 0; j <= 9; j++) {
        if (j >= 1)
          cnt[next][j - 1] = (cnt[next][j - 1] + cnt[curr][j]) % (int) 1e9;
        if (j <= 8)
          cnt[next][j + 1] = (cnt[next][j + 1] + cnt[curr][j]) % (int) 1e9;
      }
      curr ^= next;
      next ^= curr;
      curr ^= next;
      Arrays.fill(cnt[next], 0);
    }
    int ans = 0;
    for (int i : cnt[curr])
      ans = (ans + i) % (int) 1e9;
    System.out.print(ans);
  }
}
