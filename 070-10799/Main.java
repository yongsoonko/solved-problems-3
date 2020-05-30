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
    Stack<Character> S = new Stack<>();
    int ans = 0;
    S.push(str.charAt(0));
    for (int i = 1; i < str.length(); i++) {
      if (S.size() > 0 && S.peek() == '(' && str.charAt(i) == ')') {
        S.pop();
        if (str.charAt(i - 1) == '(' && str.charAt(i) == ')')
          ans += S.size();
        else
          ans++;
      } else
        S.push(str.charAt(i));
    }
    log(ans);
  }
}
