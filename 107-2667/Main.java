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
    int N = Integer.parseInt(br.readLine());
    char map[][] = new char[N][N];
    boolean chk[][] = new boolean[N][N];
    for (int i = 0; i < N; i++)
      map[i] = br.readLine().toCharArray();

    int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};
    List<Integer> ans = new ArrayList<>();
    Queue<Integer> Q = new LinkedList<>();
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        if (map[i][j] == '1' && !chk[i][j]) {
          int cnt = 0;
          chk[i][j] = true;
          Q.offer(i * 30 + j);

          while (Q.size() > 0) {
            int ci = Q.peek() / 30, cj = Q.peek() % 30;
            Q.poll();
            cnt++;
            for (int k = 0; k < 4; k++) {
              int ni = ci + di[k], nj = cj + dj[k];
              if (ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] == '1' && !chk[ni][nj]) {
                chk[ni][nj] = true;
                Q.offer(ni * 30 + nj);
              }
            }
          }
          ans.add(cnt);
        }
    Collections.sort(ans);
    log(ans.size() + "\n");
    for (int i : ans)
      log(i + "\n");
  }
}
