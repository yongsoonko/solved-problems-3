import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    // long start = System.nanoTime();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    List<Integer> J[] = new List[N + 1];
    List<Integer> rJ[] = new List[N + 1];

    for (int i = 1; i <= N; i++) {
      J[i] = new ArrayList<>();
      rJ[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      J[a].add(b);
      rJ[b].add(a);
    }

    int ans = 0;
    for (int i = 1; i <= N; i++) {
      Queue<Integer> Q = new LinkedList<>();
      Set<Integer> asc = new HashSet<>();
      Set<Integer> desc = new HashSet<>();
      Q.offer(i);
      while (Q.size() > 0) {
        int curr = Q.poll();
        for (int next : J[curr])
          if (asc.add(next))
            Q.offer(next);
      }

      Q.offer(i);
      while (Q.size() > 0) {
        int curr = Q.poll();
        for (int next : rJ[curr])
          if (desc.add(next))
            Q.offer(next);
      }

      if (asc.size() + desc.size() == N - 1)
        ans++;
    }

    log(ans);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
