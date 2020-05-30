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
    PriorityQueue<Pos> Q = new PriorityQueue<>();
    for (int i = 0; i < N; i++)
      Q.offer(parse(br.readLine()));

    while (Q.size() > 0)
      bw.write(Q.poll().name + '\n');
    bw.flush();
  }

  static Pos parse(String str) {
    int i = str.indexOf(' '), j = str.indexOf(' ', i + 1), k = str.indexOf(' ', j + 1);
    return new Pos(str.substring(0, i), parse2(str, i + 1), parse2(str, j + 1), parse2(str, k + 1));
  }

  static byte parse2(String str, int i) {
    byte num = 0;
    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9')
      num = (byte) (num * 10 + str.charAt(i++) - '0');
    return num;
  }
}
