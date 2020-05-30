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
  static int A[], B[], cnt[];

  static void log(Object o) {
    System.out.print(o);
  }


  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());

    A = new int[N + 1];
    B = new int[N + 1];

    int max = 0;
    for (int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(br.readLine());
      B[i] = A[i];
      if (max < B[i])
        max = B[i];
    }
    cnt = new int[max + 1];
    Arrays.sort(B, 1, N + 1);

    int ans = 0;
    for (int i = 1; i <= N; i++) {
      int pos = lower_bound(B, 1, N, A[i]);
      int dis = i - pos - cnt[A[i]]++;
      if (ans < dis)
        ans = dis;
    }
    log(ans + 1);
  }

  static int lower_bound(int A[], int lt, int rt, int val) {
    int res = rt + 1;
    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if (A[mid] < val)
        lt = mid + 1;
      else {
        if (res > mid)
          res = mid;
        rt = mid - 1;
      }
    }
    return res;
  }
}
