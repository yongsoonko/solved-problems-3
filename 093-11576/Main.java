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
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(br.readLine());
    int num = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++)
      num = num * A + Integer.parseInt(st.nextToken());

    Stack<Integer> S = new Stack<>();
    do {
      S.push(num % B);
      num /= B;
    } while (num > 0);

    while (S.size() > 0)
      bw.write(S.pop() + " ");
    bw.flush();
  }
}
