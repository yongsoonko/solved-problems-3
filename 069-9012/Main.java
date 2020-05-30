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
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      String str = br.readLine();
      Stack<Character> S = new Stack<>();
      for (char ch : str.toCharArray()) {
        if (S.size() > 0 && S.peek() == '(' && ch == ')')
          S.pop();
        else
          S.push(ch);
      }
      bw.write(S.isEmpty() ? "YES\n" : "NO\n");
    }
    bw.flush();
  }
}
