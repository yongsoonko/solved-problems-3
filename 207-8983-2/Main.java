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
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    int A[] = new int[M], ans = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++)
      A[i] = Integer.parseInt(st.nextToken());
    Arrays.sort(A);

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (b > L)
        continue;
      int lb = lower_bound(A, 0, A.length - 1, a), dis = (int) 2e9;
      if (lb >= 1)
        dis = Math.min(dis, Math.abs(a - A[lb - 1]) + b);
      dis = Math.min(dis, Math.abs(a - A[lb]) + b);
      if (dis <= L)
        ans++;
    }

    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }

  static int lower_bound(int A[], int lt, int rt, int val) {
    int res = rt;
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
