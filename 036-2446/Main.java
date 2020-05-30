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
    int sign = -1;
    for (int i = N - 1; i < N; i += sign) {
      for (int j = N - 1; j > i; j--)
        bw.write(' ');
      for (int j = i * 2; j >= 0; j--)
        bw.write('*');
      bw.write('\n');
      if (i == 0)
        sign = 1;
    }
    bw.flush();
  }
}
