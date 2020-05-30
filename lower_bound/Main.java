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
    // 활용 예제 : 120-10816, 127-1517, 129-2261
    int A[] = {1, 1, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6};
    int B[] = {0, 1, 2, 4, 6, 7};
    for (int i : B)
      log(lower_bound(A, 0, A.length - 1, i) + " " + upper_bound(A, 0, A.length - 1, i) + "\n");
  }

  static int lower_bound(int[] A, int lt, int rt, int val) {
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

  static int upper_bound(int[] A, int lt, int rt, int val) {
    int res = rt + 1;
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
    return res;
  }

  static int binarySearch(int[] A, int lt, int rt, int val) {
    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if (A[mid] < val)
        lt = mid + 1;
      else if (A[mid] > val)
        rt = mid - 1;
      else
        return mid;
    }
    return -1;
  }

}
