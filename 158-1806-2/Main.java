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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int sum[] = new int[N + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int a = Integer.parseInt(st.nextToken());
      sum[i + 1] = sum[i] + a;
    }

    int ans = (int) 1e9;
    for (int i = 0; i < N; i++) {
      int lt = i + 1, rt = N;
      while (lt <= rt) {
        int mid = (lt + rt) / 2;
        if (sum[mid] - sum[i] < S)
          lt = mid + 1;
        else {
          if (ans > mid - i)
            ans = mid - i;
          rt = mid - 1;
        }
      }
    }
    log(ans == (int) 1e9 ? 0 : ans);
  }
}
