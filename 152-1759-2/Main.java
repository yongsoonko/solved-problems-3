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
  static int L, C;
  static char A[], ans[];

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    A = new char[C];
    ans = new char[L];

    String str = br.readLine();
    for (int i = 0; i < C; i++)
      A[i] = str.charAt(i * 2);

    Arrays.sort(A);

    dfs(0, 0, 0);
    bw.flush();
  }

  static void dfs(int curr, int cnt, int mCnt) throws IOException {
    if (cnt == L) {
      if (mCnt >= 1 && cnt - mCnt >= 2) {
        for (char ch : ans)
          bw.write(ch);
        bw.write('\n');
      }
    } else if (curr < C) {
      ans[cnt] = A[curr];
      if (A[curr] == 'a' || A[curr] == 'e' || A[curr] == 'i' || A[curr] == 'o' || A[curr] == 'u')
        dfs(curr + 1, cnt + 1, mCnt + 1);
      else
        dfs(curr + 1, cnt + 1, mCnt);
      dfs(curr + 1, cnt, mCnt);
    }
  }
}
