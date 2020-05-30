import java.io.*;
import java.util.*;

class Pos {
  int i, j;

  Pos(int i, int j) {
    this.i = i;
    this.j = j;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    int[] dis = new int[N + 1];
    Arrays.fill(dis, 0);
    dis[N] = 1;

    Queue<Integer> Q = new LinkedList<>();
    Q.offer(N);

    while (Q.size() > 0) {
      int curr = Q.poll(), next;
      if (curr % 3 == 0 && dis[(next = curr / 3)] == 0) {
        dis[next] = dis[curr] + 1;
        Q.offer(next);
      }
      if (curr % 2 == 0 && dis[(next = curr / 2)] == 0) {
        dis[next] = dis[curr] + 1;
        Q.offer(next);
      }
      if (dis[(next = curr - 1)] == 0) {
        dis[next] = dis[curr] + 1;
        Q.offer(next);
      }
      if (dis[1] > 0) {
        System.out.print(dis[1] - 1);
        return;
      }
    }
  }
}
