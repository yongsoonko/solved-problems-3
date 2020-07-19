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
    int N = Integer.parseInt(br.readLine());
    int A[] = new int[N + 1];
    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(br.readLine());

    int ans = 0;
    for (int i = 1; i <= N; i++)
      for (int j = i - 1; j >= 0; j--) {
        if (A[j] > A[i]) {
          ans = Math.max(ans, (i - j) * A[j]);
          A[j] = A[i];
        } else
          break;
      }
    log(ans);
  }
}
