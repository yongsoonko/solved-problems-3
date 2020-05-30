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

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int K = Integer.parseInt(br.readLine());
    int color[] = new int[20001];
    boolean chk[] = new boolean[20001];
    while (K-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int V = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());

      List<List<Integer>> J = new ArrayList<>();
      for (int i = 0; i <= V; i++)
        J.add(new ArrayList<>());
      Arrays.fill(chk, 1, V + 1, false);
      Arrays.fill(color, 1, V + 1, 0);

      for (int i = 0; i < E; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        J.get(a).add(b);
        J.get(b).add(a);
      }

      Queue<Integer> Q = new LinkedList<>();
      int i;
      outer: for (i = 1; i <= V; i++) {
        if (!chk[i]) {
          Q.offer(i);
          color[i] = 1;

          while (Q.size() > 0) {
            int curr = Q.poll();
            for (int next : J.get(curr))
              if (!chk[next]) {
                if (color[next] == 0) {
                  color[next] = (color[curr] == 1 ? 2 : 1);
                  Q.offer(next);
                } else if (color[curr] == color[next])
                  break outer;
              }
            chk[curr] = true;
          }
        }
      }
      bw.write(i > V ? "YES\n" : "NO\n");
    }
    bw.flush();
  }
}
