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
    String str = br.readLine();
    for (int i = 0; i < str.length(); i++) {
      if (i > 0 && i % 10 == 0)
        bw.write('\n');
      bw.write(str.charAt(i));
    }
    bw.flush();
  }
}
