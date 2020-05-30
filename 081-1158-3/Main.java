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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    bw.write('<');
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= N; i++)
      list.add(i);

    int p = -1;
    while (list.size() > 0) {
      p = (p + K) % list.size();
      bw.write(list.size() == 1 ? list.remove(p--) + ">" : list.remove(p--) + ", ");
    }
    bw.flush();
  }
}
