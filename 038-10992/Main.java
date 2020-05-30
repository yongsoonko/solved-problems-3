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
    for (int i = 1; i < N; i++) {
      for (int j = i; j < N; j++)
        bw.write(' ');
      bw.write('*');
      for (int j = i * 2 - 4; j >= 0; j--)
        bw.write(' ');
      if (i >= 2)
        bw.write('*');
      bw.write('\n');
    }
    for (int i = N * 2 - 1; i >= 1; i--)
      bw.write('*');
    bw.flush();
  }
}
