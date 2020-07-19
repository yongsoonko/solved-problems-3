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
    char A[] = br.readLine().toCharArray();
    char B[] = br.readLine().toCharArray();
    char ans[] = new char[A.length];
    int p = 0;

    out: for (int i = 0; i < A.length; i++) {
      ans[p++] = A[i];
      if (p >= B.length) {
        int j = p - B.length;
        for (int k = 0; j < p; j++, k++)
          if (ans[j] != B[k])
            continue out;
        p -= B.length;
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(ans, 0, p);

    log(sb.length() == 0 ? "FRULA" : sb);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
