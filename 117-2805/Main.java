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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int A[] = new int[N];

    int maxH = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
      maxH = Math.max(maxH, A[i]);
    }

    long lt = 0, rt = maxH, ans = 0;
    while (lt <= rt) {
      long mid = (lt + rt) / 2, sum = 0;
      for (int i : A)
        sum += i - mid > 0 ? i - mid : 0;
      if (sum >= M) {
        ans = Math.max(ans, mid);
        lt = mid + 1;
      } else
        rt = mid - 1;
    }
    log(ans);
  }
}
