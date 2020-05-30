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
    String str;
    while ((str = br.readLine()).charAt(0) != '0') {
      StringTokenizer st = new StringTokenizer(str);
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      bw.write(A + B + "\n");
    }
    bw.flush();
  }
}
