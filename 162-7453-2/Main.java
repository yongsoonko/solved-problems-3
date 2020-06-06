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

    int sumAB[] = new int[N * N];
    int sumCD[] = new int[N * N];

    int sz = 0;
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        sumAB[sz++] = A[i] + B[j];

    sz = 0;
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        sumCD[sz++] = C[i] + D[j];

    Arrays.sort(sumAB);
    Arrays.sort(sumCD);

    long ans = 0;
    int p = 0, q = sz - 1;
    while (p < sz && q >= 0) {
      int sum = sumAB[p] + sumCD[q];
      if (sum < 0) {
        int nextP = p;
        while (nextP < sz && sumAB[nextP] == sumAB[p])
          nextP++;
        p = nextP;
      } else {
        int nextQ = q;
        while (nextQ >= 0 && sumCD[nextQ] == sumCD[q])
          nextQ--;
        if (sum == 0) {
          int nextP = p;
          while (nextP < sz && sumAB[nextP] == sumAB[p])
            nextP++;
          ans += (long) (nextP - p) * (q - nextQ);
          p = nextP;
        }
        q = nextQ;
      }
    }
    log(ans);
  }
}
