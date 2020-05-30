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
    Map<Integer, Integer> A = new HashMap<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int key = Integer.parseInt(st.nextToken());
      Integer val;
      if ((val = A.get(key)) == null)
        A.put(key, 1);
      else
        A.put(key, val + 1);
    }

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int a = Integer.parseInt(st.nextToken());
      Integer val;
      bw.write(((val = A.get(a)) == null ? 0 : val) + " ");
    }
    bw.flush();
  }
}
