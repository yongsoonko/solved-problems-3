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
    int N = Integer.parseInt(br.readLine());
    for (int i = 1; i <= N; i++) {
      for (int j = i; j < N; j++)
        bw.write(' ');
      for (int j = 0; j < i; j++)
        bw.write("* ");
      bw.write('\n');
    }
    bw.flush();
  }
}
