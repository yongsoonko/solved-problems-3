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

    int sign = 1;
    for (int i = 1; i > 0; i += sign) {
      for (int j = i + 1; j <= N; j++)
        bw.write(' ');
      for (int j = 1; j <= i; j++)
        bw.write('*');
      bw.write('\n');
      if (i == N)
        sign = -1;
    }
    bw.flush();
  }
}
