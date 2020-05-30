import java.io.*;
import java.util.*;

class Pos {
  int i, j;

  Pos(int i, int j) {
    this.i = i;
    this.j = j;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    int n, w, L;
    int[] A, cnt;

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());

    A = new int[n];
    cnt = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      A[i] = Integer.parseInt(st.nextToken());

    int p = 0, q = 0, curr = 0, ans = 0;
    while (p < n) {
      for (int i = p; i < q; i++)
        cnt[i]++;
      if (cnt[p] > w) {
        curr -= A[p];
        p++;
      }
      if (q < n && L - curr >= A[q]) {
        cnt[q]++;
        curr += A[q];
        q++;
      }
      ans++;
    }
    System.out.print(ans);
  }
}
