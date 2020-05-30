import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int i, j;

  Pos(int i, int j) {
    this.i = i;
    this.j = j;
  }

  @Override
  public int compareTo(Pos o) {
    return i - o.i;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    int N, P;
    ArrayList<Pos> A = new ArrayList<>();
    N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int i = 0; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      A.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
    P = A.get(A.size() - 1).j;

    A.sort(null);

    PriorityQueue<Pos> Q = new PriorityQueue<>(new Comparator<Pos>() {
      @Override
      public int compare(Pos o1, Pos o2) {
        return o2.j - o1.j;
      }
    });

    int prev = 0, ans = 0;
    for (Pos p : A) {
      while (P - (p.i - prev) < 0) {
        if (Q.size() == 0) {
          System.out.print(-1);
          return;
        }
        P += Q.poll().j;
        ans++;
      }
      P -= (p.i - prev);
      prev = p.i;
      Q.add(new Pos(p.i, p.j));
    }
    System.out.print(ans);
  }
}
