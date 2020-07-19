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
    String B = br.readLine();

    StringBuilder sb = new StringBuilder();
    for (char ch : A) {
      sb.append(ch);
      int p = sb.length();
      if (p >= B.length() && sb.substring(p - B.length(), p).contentEquals(B))
        sb.delete(p - B.length(), p);
    }
    log(sb.length() == 0 ? "FRULA" : sb);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
