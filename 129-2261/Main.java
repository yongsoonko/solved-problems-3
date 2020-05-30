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
    int n = Integer.parseInt(br.readLine());
    Pos A[] = new Pos[n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      A[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    Arrays.sort(A);
    log(dfs(A, 0, n - 1));
  }

  static int dfs(Pos[] A, int lt, int rt) {
    // 2개 또는 3개일 때
    if (rt - lt <= 2) {
      int min = (int) 2e9;
      for (int i = lt; i < rt; i++)
        for (int j = i + 1; j <= rt; j++)
          min = Math.min(min, dis(A[i], A[j]));
      return min;
    }

    int mid = (lt + rt) / 2;
    int min = Math.min(dfs(A, lt, mid), dfs(A, mid + 1, rt));

    double midX = (A[mid].i + A[mid + 1].i) / 2.;
    double minDis = Math.sqrt(min);

    List<Pos> list = new ArrayList<Pos>();
    int ltIdx = lower_bound(A, lt, rt, midX - minDis);
    int rtIdx = lower_bound(A, lt, rt, midX + minDis);
    for (int i = ltIdx; i < rtIdx; i++)
      list.add(A[i]);

    Collections.sort(list, new Comparator<Pos>() {
      public int compare(Pos o1, Pos o2) {
        return o1.j == o2.j ? o1.i - o2.i : o1.j - o2.j;
      }
    });

    for (int i = 0; i < list.size() - 1; i++)
      for (int j = i + 1; j < list.size(); j++) { // 최대 3개이므로 O(N^2)이 아닌 O(3N)
        if (list.get(j).j - list.get(i).j <= minDis)
          min = Math.min(min, dis(list.get(i), list.get(j)));
        else
          break;
      }

    return min;
  }

  static int lower_bound(Pos A[], int lt, int rt, double val) {
    int res = rt + 1;
    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if (A[mid].i < val)
        lt = mid + 1;
      else {
        if (res > mid)
          res = mid;
        rt = mid - 1;
      }
    }
    return res;
  }

  static int dis(Pos a, Pos b) {
    return (a.i - b.i) * (a.i - b.i) + (a.j - b.j) * (a.j - b.j);
  }
}
