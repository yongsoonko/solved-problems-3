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
    int A[] = new int[N];
    int cntA[] = new int[4000001], cntB[];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(st.nextToken());

    if (N <= 20) {
      dfs(0, N, 0, A, cntA);
      log(S == 0 ? cntA[2000000] - 1 : cntA[S + 2000000]);
    } else {
      long ans = 0;
      cntB = new int[4000001];
      dfs(0, 20, 0, A, cntA);
      dfs(20, N, 0, A, cntB);
      int p = -2000000, q = 2000000, sum = 0;
      while (true) {
        if (sum < S){
          sum++;
          p++;
        }
        else if (sum >= S) {
          if (sum == S) {
            int lo = p, hi = q;
            while (p <= hi && q >= lo)
              ans += (long) cntA[p++ + 2000000] * cntB[q-- + 2000000];
            break;
          }
          sum--;
          q--;
        }
      }
      log(S == 0 ? ans - 1 : ans);
    }
  }

  static void dfs(int curr, int N, int sum, int A[], int cnt[]) {
    if (curr == N)
      cnt[sum + 2000000]++;
    else {
      dfs(curr + 1, N, sum + A[curr], A, cnt);
      dfs(curr + 1, N, sum, A, cnt);
    }
  }
}
