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
    int C = Integer.parseInt(st.nextToken());
    int A[] = new int[N];

    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(br.readLine());

    Arrays.sort(A);
    int lt = 1, rt = A[N - 1] - A[0], ans = 0;
    while (lt <= rt) {
      int mid = (lt + rt) / 2, cnt = 1, prev = A[0];
      for (int i = 1; i < N; i++)
        if (A[i] - prev >= mid) {
          cnt++;
          prev = A[i];
        }
      if (cnt >= C) {
        ans = Math.max(ans, mid);
        lt = mid + 1;
      } else
        rt = mid - 1;
    }
    log(ans);
  }
}
