import java.io.*;
import java.util.*;

class Pos {
  int i, j;

  Pos(int i, int j) {
    this.i = i;
    this.j = j;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String x, y;
      x = st.nextToken();
      y = st.nextToken();
      bw.write("Distances:");
      for (int i = 0; i < x.length(); i++)
        bw.write(" " + ((y.charAt(i) - x.charAt(i) + 26) % 26));
      bw.write('\n');
    }
    bw.flush();
  }
}
