import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  String name;
  byte i;
  byte j;
  byte k;

  Pos(String name, byte i, byte j, byte k) {
    this.name = name;
    this.i = i;
    this.j = j;
    this.k = k;
  }

  public int compareTo(Pos p) {
    if (i == p.i && j == p.j && k == p.k)
      return name.compareTo(p.name);
    else if (i == p.i && j == p.j)
      return p.k - k;
    else if (i == p.i)
      return j - p.j;
    else
      return p.i - i;
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
      A[i] = new Pos(st.nextToken(), Byte.parseByte(st.nextToken()), Byte.parseByte(st.nextToken()),
          Byte.parseByte(st.nextToken()));
    }

    Arrays.sort(A);
    for (Pos p : A)
      bw.write(p.name + '\n');
    bw.flush();
  }
}
