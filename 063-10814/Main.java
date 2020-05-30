import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int i;
  int j;
  String k;

  Pos(int i, int j, String k) {
    this.i = i;
    this.j = j;
    this.k = k;
  }

  public int compareTo(Pos p) {
    return j == p.j ? i - p.i : j - p.j;
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
    for (int i = 0; i < N; i++)
      A[i] = parse(i, br.readLine());

    Arrays.sort(A);
    for (Pos p : A)
      bw.write(p.j + p.k + "\n");
    bw.flush();
  }

  static Pos parse(int order, String str) {
    int num = 0, i = 0;
    while (str.charAt(i) >= '0' && str.charAt(i) <= '9')
      num = num * 10 + str.charAt(i++) - '0';
    return new Pos(order, num, str.substring(i));
  }
}
