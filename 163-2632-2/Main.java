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
    int sz = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    int A[] = new int[m];
    int B[] = new int[n];
    int sumA[] = new int[m];
    int sumB[] = new int[n];
    int cntA[] = new int[1000001];
    int cntB[] = new int[1000001];
    cntA[0] = cntB[0] = 1;

    int sum = 0;
    for (int i = 0; i < m; i++) {
      A[i] = Integer.parseInt(br.readLine());
      sumA[i] = A[i];
      cntA[A[i]]++;
      sum += A[i];
    }
    cntA[sum]++;

    sum = 0;
    for (int i = 0; i < n; i++) {
      B[i] = Integer.parseInt(br.readLine());
      sumB[i] = B[i];
      cntB[B[i]]++;
      sum += B[i];
    }
    cntB[sum]++;

    for (int i = 1; i < m - 1; i++)
      for (int j = 0; j < m; j++) {
        sumA[j] = sumA[j] + A[(j + i) % m];
        cntA[sumA[j]]++;
      }

    for (int i = 1; i < n - 1; i++)
      for (int j = 0; j < n; j++) {
        sumB[j] = sumB[j] + B[(j + i) % n];
        cntB[sumB[j]]++;
      }

    long ans = 0;
    int p = 0, q = 1000000;
    sum = 1000000;
    while (true) {
      if (sum < sz) {
        sum++;
        p++;
      } else {
        if (sum == sz) {
          int lo = p, hi = q;
          while (p <= hi && q >= lo)
            ans += (long) cntA[p++] * cntB[q--];
          break;
        }
        sum--;
        q--;
      }
    }
    log(ans);
  }
}
