import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

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
  static int D[] = new int[10];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    for (int i = 0, num = 1; i < 10; i++, num *= 10)
      D[i] = num;

    int seq[] = new int[362880];
    boolean chk[] = new boolean[362880];
    int A[] = IntStream.range(1, 10).toArray(), idx = 0;
    do {
      int sum = 0;
      for (int i : A)
        sum = sum * 10 + i;
      seq[idx++] = sum;
    } while (next_permutation(A));

    int curr = 0;
    for (int i = 0; i < 3; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        int num = Integer.parseInt(st.nextToken());
        if (num == 0)
          num = 9;
        curr = curr * 10 + num;
      }
    }

    int end = 123456789;

    Queue<Integer> Q = new LinkedList<>();
    Q.offer(curr);
    chk[Arrays.binarySearch(seq, curr)] = true;

    int ans = 0;
    out: while (Q.size() > 0) {
      if (chk[0]) {
        log(ans);
        return;
      }
      ans++;
      int sz = Q.size();
      while (sz-- > 0) {
        curr = Q.poll();
        int zi = 0, zj = 0, num = curr;
        for (int i = 0; i < 9; i++, num /= 10)
          if (num % 10 == 9) {
            zi = i / 3;
            zj = i % 3;
            break;
          }
        int zIdx = zi * 3 + zj;
        for (int i = 0; i < 4; i++) {
          int ni = zi + di[i], nj = zj + dj[i];
          if (ni >= 0 && ni < 3 && nj >= 0 && nj < 3) {
            int next = swap(curr, zIdx, ni * 3 + nj), nIdx = 0;
            if (!chk[nIdx = Arrays.binarySearch(seq, next)]) {
              chk[nIdx] = true;
              Q.offer(next);

              if (next == end)
                continue out;
            }
          }
        }
      }
    }
    log(-1);
  }

  static boolean next_permutation(int A[]) {
    int pv = 0;
    for (int i = 1; i < A.length; i++)
      if (A[i - 1] < A[i])
        pv = i;

    if (pv == 0)
      return false;

    for (int i = A.length - 1; i >= pv; i--)
      if (A[pv - 1] < A[i]) {
        swap2(A, pv - 1, i);
        break;
      }

    int p = pv, q = A.length - 1;
    while (p < q)
      swap2(A, p++, q--);

    return true;
  }

  static void swap2(int A[], int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
  }

  static int swap(int a, int i, int j) {
    int d1 = D[i], d2 = D[j];
    int v1 = a / d1 % 10, v2 = a / d2 % 10;
    return a - v1 * d1 + v1 * d2 - v2 * d2 + v2 * d1;
  }
}
