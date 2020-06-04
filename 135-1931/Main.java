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
    return j == p.j ? i - p.i : j - p.j;
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
    Pos A[] = new Pos[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      A[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    Arrays.sort(A);

    int ans = 0, end = -1;
    for (Pos p : A)
      if (end <= p.i) {
        ans++;
        end = p.j;
      }

    log(ans);
  }
}
