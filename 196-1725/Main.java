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
    int N = Integer.parseInt(br.readLine());
    int A[] = new int[N];
    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(br.readLine());

    log(dfs(A, 0, N - 1));
  }

  static int dfs(int A[], int lt, int rt) {
    if (lt == rt)
      return A[lt];

    int mid = (lt + rt) / 2;
    int res = dfs(A, lt, mid);
    res = Math.max(res, dfs(A, mid + 1, rt));

    int p = mid, q = mid + 1, height = Math.min(A[p], A[q]), width = 2;
    res = Math.max(res, height * width);
    while (p > lt && q < rt) {
      width++;
      if (A[p - 1] > A[q + 1]) {
        if (height > A[p - 1])
          height = A[p - 1];
        p--;
      } else {
        if (height > A[q + 1])
          height = A[q + 1];
        q++;
      }
      res = Math.max(res, height * width);
    }

    while (p > lt) {
      width++;
      if (height > A[p - 1])
        height = A[p - 1];
      p--;
      res = Math.max(res, height * width);
    }

    while (q < rt) {
      width++;
      if (height > A[q + 1])
        height = A[q + 1];
      q++;
      res = Math.max(res, height * width);
    }

    return res;
  }
}
