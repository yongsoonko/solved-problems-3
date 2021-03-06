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
    int A[] = new int[N];
    int B[] = new int[N];
    int C[] = new int[N];
    int D[] = new int[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      A[i] = Integer.parseInt(st.nextToken());
      B[i] = Integer.parseInt(st.nextToken());
      C[i] = Integer.parseInt(st.nextToken());
      D[i] = Integer.parseInt(st.nextToken());
    }

    Map<Integer, Integer> mapAB = new HashMap<Integer, Integer>();
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++) {
        int sum = A[i] + B[j];
        Integer cnt;
        if ((cnt = mapAB.get(sum)) != null)
          mapAB.put(sum, cnt + 1);
        else
          mapAB.put(sum, 1);
      }

    long ans = 0;
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++) {
        Integer cnt;
        if ((cnt = mapAB.get(-(C[i] + D[j]))) != null)
          ans += cnt;
      }
    log(ans);
  }
}
