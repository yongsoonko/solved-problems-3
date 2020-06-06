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
    int T = Integer.parseInt(br.readLine());

    int n = Integer.parseInt(br.readLine());
    int A[] = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      A[i] = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(br.readLine());
    int B[] = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++)
      B[i] = Integer.parseInt(st.nextToken());

    Map<Integer, Integer> map = new HashMap<>();
    int sumA[] = new int[n];
    for (int i = 0; i < n; i++)
      for (int j = i; j < n; j++) {
        sumA[j - i] = sumA[j - i] + A[j];
        Integer cnt;
        if ((cnt = map.get(sumA[j - i])) != null)
          map.put(sumA[j - i], cnt + 1);
        else
          map.put(sumA[j - i], 1);
      }

    long ans = 0;
    int sumB[] = new int[m];
    for (int i = 0; i < m; i++)
      for (int j = i; j < m; j++) {
        sumB[j - i] = sumB[j - i] + B[j];
        Integer cnt;
        if ((cnt = map.get(T - sumB[j - i])) != null)
          ans += cnt;
      }
    log(ans);
  }
}
