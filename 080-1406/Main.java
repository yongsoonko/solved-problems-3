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
    String str = br.readLine();
    LinkedList<Character> list = new LinkedList<>();
    for (char ch : str.toCharArray())
      list.add(ch);
    ListIterator<Character> it = list.listIterator(list.size());

    int M = Integer.parseInt(br.readLine());
    while (M-- > 0) {
      String op = br.readLine();
      if (op.charAt(0) == 'L' && it.hasPrevious())
        it.previous();
      else if (op.charAt(0) == 'D' && it.hasNext())
        it.next();
      else if (op.charAt(0) == 'B' && it.hasPrevious()) {
        it.previous();
        it.remove();
      } else if (op.charAt(0) == 'P')
        it.add(op.charAt(2));
    }
    for (char ch : list)
      bw.write(ch);
    bw.flush();
  }
}
