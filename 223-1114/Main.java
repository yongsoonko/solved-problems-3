import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int L = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    // 0, 1 ~ K, K+1
    int A[] = new int[K + 2];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= K; i++)
      A[i] = Integer.parseInt(st.nextToken());
    A[K + 1] = L;

    Arrays.sort(A);

    int ansLen = (int) 1e9, ansPos = 0;
    int lt = 1, rt = L;
    out: while (lt <= rt) {
      int mid = (lt + rt) / 2, cnt = 0, prev = 0, once = -1;
      while (prev <= K) {
        int next = upper_bound(A, prev, A.length - 1, A[prev] + mid) - 1;
        if (next <= prev) {
          lt = mid + 1;
          continue out;
        }
        if (once == -1)
          once = next;
        if (next <= K)
          cnt++;
        prev = next;
      }

      if (cnt <= C) {
        if (ansLen > mid) {
          ansLen = mid;
          ansPos = once;
        }
        rt = mid - 1;
      } else
        lt = mid + 1;
    }

    out: for (int i = ansPos; i >= 1; i--) {
      int prev = i, cnt = 1;
      while (prev <= K) {
        int next = upper_bound(A, prev, A.length - 1, A[prev] + ansLen) - 1;
        if (next <= prev)
          continue out;
        if (next <= K)
          cnt++;
        prev = next;
      }
      if (cnt <= C)
        ansPos = i;
      else
        break;
    }

    System.out.println(ansLen + " " + A[ansPos]);
    // System.out.println("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms");
  }

  public static int upper_bound(int A[], int lt, int rt, int val) {
    int res = A.length;
    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if (A[mid] > val) {
        if (res > mid)
          res = mid;
        rt = mid - 1;
      } else
        lt = mid + 1;
    }
    return res;
  }
}
