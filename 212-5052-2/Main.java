import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    int t = Integer.parseInt(br.readLine());
    out: while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      String A[] = new String[n];
      for (int i = 0; i < n; i++)
        A[i] = br.readLine();

      Arrays.sort(A);
      in: for (int i = 1; i < n; i++) {
        for (int j = 0; j < A[i - 1].length() && j < A[i].length(); j++)
          if (A[i - 1].charAt(j) != A[i].charAt(j))
            continue in;
        bw.write("NO\n");
        continue out;
      }
      bw.write("YES\n");
    }
    bw.flush();

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
