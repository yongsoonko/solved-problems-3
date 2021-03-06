import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int i;
  int j;
  List<List<Integer>> A;

  Pos(int i, int j, List<List<Integer>> A) {
    this.i = i;
    this.j = j;
    this.A = A;
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
    Pos curr;
    List<List<Integer>> A = new ArrayList<>();
    List<List<Integer>> E = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      A.add(new ArrayList<>());
      E.add(new ArrayList<>());
    }
    int zi = 0, zj = 0;
    for (int i = 0; i < 3; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        int a = Integer.parseInt(st.nextToken());
        A.get(i).add(a);
        if (a == 0) {
          zi = i;
          zj = j;
        }
        E.get(i).add(1 + i * 3 + j);
      }
    }
    curr = new Pos(zi, zj, A);
    E.get(2).set(2, 0);

    Set<List<List<Integer>>> chk = new HashSet<>();
    chk.add(curr.A);
    Queue<Pos> Q = new LinkedList<>();
    Q.offer(curr);

    int ans = 0;
    out: while (Q.size() > 0) {
      if (chk.contains(E)) {
        log(ans);
        return;
      }
      ans++;
      int sz = Q.size();
      while (sz-- > 0) {
        zi = Q.peek().i;
        zj = Q.peek().j;
        A = Q.peek().A;
        Q.poll();
        for (int i = 0; i < 4; i++) {
          int ni = zi + di[i], nj = zj + dj[i];
          if (ni >= 0 && ni < 3 && nj >= 0 && nj < 3) {
            List<List<Integer>> B = new ArrayList<>();
            for (int k = 0; k < 3; k++) {
              B.add(new ArrayList<>());
              for (int j = 0; j < 3; j++)
                B.get(k).add(A.get(k).get(j));
            }
            swap(B, zi, zj, ni, nj);
            if (!chk.contains(B)) {
              chk.add(B);
              Q.offer(new Pos(ni, nj, B));

              if (B.equals(E))
                continue out;
            }
          }
        }
      }
    }
    log(-1);
  }

  static void swap(List<List<Integer>> A, int i1, int j1, int i2, int j2) {
    int tmp = A.get(i1).get(j1);
    A.get(i1).set(j1, A.get(i2).get(j2));
    A.get(i2).set(j2, tmp);
  }
}
