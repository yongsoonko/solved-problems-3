import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
  static int N, A[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    N = Integer.parseInt(br.readLine());
    A = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(st.nextToken());
    int target = Integer.parseInt(br.readLine());

    dfs(0, A, target);
    log("false");

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static void dfs(int start, int A[], int target) {
    if (target == 0) {
      log("true");
      System.exit(0);
    } else if (start < A.length) {
      int i, add = A[start];
      for (i = start + 1; i < A.length && A[i - 1] == A[i]; i++)
        add += A[start];
      dfs(i, A, target - add);
      dfs(i, A, target);
    }
  }
}
