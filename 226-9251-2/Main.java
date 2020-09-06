import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static char A[], B[];
  static int dp[], ans;

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    A = br.readLine().toCharArray();
    B = br.readLine().toCharArray();
    dp = new int[Math.min(A.length, B.length) + 1];
    Arrays.fill(dp, (int) 1e9);
    dp[0] = -1;

    if (A.length > B.length) {
      char tmp[] = B;
      B = A;
      A = tmp;
    }

    for (int i = 0; i < A.length; i++)
      for (int j = i; j >= 0; j--)
        if (dp[j] < (int) 1e9)
          for (int k = dp[j] + 1; k < B.length; k++)
            if (A[i] == B[k]) {
              dp[j + 1] = Math.min(dp[j + 1], k);
              break;
            }

    for (int i = 1; i < dp.length; i++)
      if (dp[i] < (int) 1e9)
        ans = i;

    System.out.println(ans);

    // System.out.println("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms");
  }
}
