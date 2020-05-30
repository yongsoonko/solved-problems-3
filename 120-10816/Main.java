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
    int A[] = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(A);
    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int val = Integer.parseInt(st.nextToken());
      bw.write(upper_bound(A, val) - lower_bound(A, val) + " ");
    }
    bw.flush();

    // int B[] = {1, 1, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6};
    // int C[] = {0, 1, 2, 4, 6, 7};
    // for (int i : C)
    //   log(upper_bound(B, i) + " " + lower_bound(B, i) + "\n");
  }

  static int lower_bound(int[] A, int val) {
    int lt = 0, rt = A.length - 1, res = (int) 2e9;
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
    return res == (int) 2e9 ? A.length : res;
  }

  static int upper_bound(int[] A, int val) {
    int lt = 0, rt = A.length - 1, res = (int) 2e9;
    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if (A[mid] <= val)
        lt = mid + 1;
      else {
        if (res > mid)
          res = mid;
        rt = mid - 1;
      }
    }
    return res == (int) 2e9 ? A.length : res;
  }
}
