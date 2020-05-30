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
    int T = Integer.parseInt(br.readLine());
    for (int i = 1; i <= T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      bw.write("Case #" + i + ": " + A + " + " + B + " = " + (A + B) + "\n");
    }
    bw.flush();
  }
}
