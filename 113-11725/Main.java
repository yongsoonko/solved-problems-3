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
  static int chk[];
  static List<List<Integer>> J;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    J = new ArrayList<>();
    for (int i = 0; i <= N; i++)
      J.add(new ArrayList<>());
    chk = new int[N + 1];
    for (int i = 1; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      J.get(a).add(b);
      J.get(b).add(a);
    }

    Queue<Integer> Q = new LinkedList<>();
    chk[1] = -1;
    Q.offer(1);

    while (Q.size() > 0) {
      int curr = Q.poll();
      for (int next : J.get(curr))
        if (chk[next] == 0) {
          chk[next] = curr;
          Q.offer(next);
        }
    }

    for (int i = 2; i <= N; i++)
      bw.write(chk[i] + "\n");
    bw.flush();
  }
}
