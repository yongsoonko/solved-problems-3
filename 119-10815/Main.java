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
    List<Integer> B = new ArrayList<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      // A[i] = Integer.parseInt(st.nextToken());
      B.add(Integer.parseInt(st.nextToken()));

    // Arrays.sort(A);
    Collections.sort(B);

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int val = Integer.parseInt(st.nextToken());
      // bw.write((binarySearch(A, 0, N - 1, val) >= 0 ? 1 : 0) + " ");
      bw.write((Collections.binarySearch(B, val) >= 0 ? 1 : 0) + " ");
    }
    bw.flush();
  }

  static int binarySearch(int[] A, int lt, int rt, int val) {
    if (lt > rt)
      return -1;
    int mid = (lt + rt) / 2;
    if (A[mid] < val)
      return binarySearch(A, mid + 1, rt, val);
    else if (A[mid] > val)
      return binarySearch(A, lt, mid - 1, val);
    else
      return mid;
  }
}
