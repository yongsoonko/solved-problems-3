import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static char A[], B[];
  static int dp[][];

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    A = br.readLine().toCharArray();
    B = br.readLine().toCharArray();
    dp = new int[B.length + 1][A.length + 1];

    for (int i = 1; i <= B.length; i++)
      for (int j = 1; j <= A.length; j++) {
        if (A[j - 1] == B[i - 1])
          dp[i][j] = dp[i - 1][j - 1] + 1;
        else
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }

    System.out.println(dp[B.length][A.length]);

    // System.out.println("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms");
  }
}
