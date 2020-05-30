import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int i, j;

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
    int N = Integer.parseInt(br.readLine());
    Pos A[] = new Pos[N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      A[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    Arrays.sort(A);
    for (Pos p : A)
      bw.write(p.i + " " + p.j + "\n");
    bw.flush();
  }
}
