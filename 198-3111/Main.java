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
    String A = br.readLine();
    String rA = new StringBuilder(A).reverse().toString();
    char T[] = br.readLine().toCharArray();

    StringBuilder lt = new StringBuilder(), rt = new StringBuilder();
    int p = 0, q = T.length;
    while (p < q) {
      while (p < q) {
        char ch = T[p++];
        lt.append(ch);
        if (lt.length() >= A.length()
            && lt.substring(lt.length() - A.length(), lt.length()).contentEquals(A)) {
          lt.delete(lt.length() - A.length(), lt.length());
          break;
        }
      }

      while (p < q) {
        char ch = T[--q];
        rt.append(ch);
        if (rt.length() >= rA.length()
            && rt.substring(rt.length() - rA.length(), rt.length()).contentEquals(rA)) {
          rt.delete(rt.length() - rA.length(), rt.length());
          break;
        }
      }

      // log(lt + " " + new StringBuilder(rt).reverse() + "\n");
    }

    lt.append(rt.reverse());
    p = 0;
    while ((p = lt.indexOf(A, p)) != -1) {
      lt.delete(p, p + A.length());
      p = Math.max(0, p - A.length() + 1);
    }
    bw.write(lt.toString());
    bw.flush();

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
