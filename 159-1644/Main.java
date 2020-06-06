import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int i;
  int j;

  Pos(int i, int j) {
    this.i = i;
    this.j = j;
  }

  public int compareTo(Pos p) {
    return i == p.i ? j - p.j : i - p.i;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    boolean prime[] = new boolean[N + 1];

    prime[1] = true;
    for (int i = 2; i * i <= N; i++)
      if (!prime[i])
        for (int j = i + i; j <= N; j += i)
          prime[j] = true;

    int p = 2, q = 2, sum = 0, ans = 0;
    while (true) {
      if (sum < N) {
        while (q <= N && prime[q])
          q++;
        if (q > N)
          break;
        sum += q++;
      } else {
        if (sum == N)
          ans++;
        while (prime[p])
          p++;
        sum -= p++;
      }
    }
    log(ans);
  }
}
