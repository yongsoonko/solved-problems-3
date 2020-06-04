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

    int cntN = 0, cnt0 = 0, cnt1 = 0, cntP = 0;
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(br.readLine());
      if (A[i] < 0)
        cntN++;
      else if (A[i] == 0)
        cnt0++;
      else if (A[i] == 1)
        cnt1++;
      else if (A[i] > 1)
        cntP++;
    }
    Arrays.sort(A);

    long ans = 0;
    for (int i = 0; i < cntN - 1; i += 2)
      ans += A[i] * A[i + 1];
    if (cntN % 2 == 1 && cnt0 == 0)
      ans += A[cntN - 1];
    for (int i = 1; i <= cntP - 1; i += 2)
      ans += A[N - i] * A[N - i - 1];
    if (cntP % 2 == 1)
      ans += A[N - cntP];
    ans += cnt1;

    log(ans);
  }
}
