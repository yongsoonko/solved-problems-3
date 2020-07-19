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
    int K = Integer.parseInt(st.nextToken());
    char A[] = br.readLine().toCharArray();
    int cnt = K;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      char curr = A[i];
      while (cnt > 0 && sb.length() + N - i > N - K && sb.length() > 0
          && sb.charAt(sb.length() - 1) < curr) {
        sb.deleteCharAt(sb.length() - 1);
        cnt--;
      }
      if (sb.length() < N - K)
        sb.append(curr);
    }

    log(sb);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
