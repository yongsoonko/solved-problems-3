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
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int A[] = new int[] {a, b, c};
    List<Integer> ans = new ArrayList<>();

    boolean chk[] = new boolean[201 * 201 * 201];
    chk[c] = true;

    Queue<Integer> Q = new LinkedList<>();
    Q.offer(c);

    while (Q.size() > 0) {
      int B[] = new int[3], tmp[] = new int[3], curr = Q.poll();
      for (int i = 2; i >= 0; i--, curr /= 201)
        B[i] = curr % 201;
      if (B[0] == 0)
        ans.add(B[2]);
      for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
          if (i != j) {
            int w = Math.min(B[i], A[j] - B[j]);
            tmp[i] = B[i] - w;
            tmp[j] = B[j] + w;
            tmp[3 - i - j] = B[3 - i - j];
            int next = 0;
            for (int d = 0; d < 3; d++)
              next = next * 201 + tmp[d];
            if (!chk[next]) {
              chk[next] = true;
              Q.offer(next);
            }
          }
    }
    ans.sort(null);
    for (int i : ans)
      bw.write(i + " ");
    bw.flush();
  }
}
