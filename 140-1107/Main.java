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
    int M = Integer.parseInt(br.readLine());
    int chk[] = new int[10];
    if (M > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; i++)
        chk[Integer.parseInt(st.nextToken())] = 1;
    }

    int ans = Math.abs(N - 100), cnt = 0, dis;
    for (dis = 0; dis < 500000; dis++) {
      if (N - dis >= 0 && (cnt = canGo(N - dis, chk)) > 0)
        break;
      if ((cnt = canGo(N + dis, chk)) > 0)
        break;
    }
    log(Math.min(ans, dis + cnt));
  }

  static int canGo(int num, int chk[]) {
    int cnt = 0;
    while (chk[num % 10] == 0) {
      cnt++;
      if ((num /= 10) == 0)
        break;
    }
    if (num == 0 && cnt > 0)
      return cnt;
    return 0;
  }
}
