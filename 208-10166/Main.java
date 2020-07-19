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
    int D1 = Integer.parseInt(st.nextToken());
    int D2 = Integer.parseInt(st.nextToken());
    int chk[][] = new int[D2 + 1][D2 + 1];

    int ans = 0;
    for (int i = D1; i <= D2; i++)
      for (int j = 1; j <= i; j++) {
        int g = gcd(i, j);
        if (chk[i / g][j / g] == 0) {
          chk[i / g][j / g] = 1;
          ans++;
        }
      }

    log(ans);


    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
