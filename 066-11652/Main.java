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

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    long A[] = new long[N];
    for (int i = 0; i < N; i++)
      A[i] = Long.parseLong(br.readLine());

    Arrays.sort(A);
    long ans = A[0];
    int maxCnt = 1, cnt = 1;
    for (int i = 1; i < N; i++) {
      if (A[i - 1] == A[i]) {
        cnt++;
        if (maxCnt < cnt) {
          maxCnt = cnt;
          ans = A[i];
        }
      } else
        cnt = 1;
    }

    log(ans);
  }

}
