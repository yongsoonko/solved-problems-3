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
    StringBuilder sb = new StringBuilder();

    int sign = 1;
    for (int i = 1; i > 0; i += sign) {
      for (int j = 1; j <= i; j++)
        sb.append('*');
      for (int j = (N - i) * 2; j > 0; j--)
        sb.append(' ');
      for (int j = 1; j <= i; j++)
        sb.append('*');
      sb.append('\n');
      if (i == N)
        sign = -1;
    }
    System.out.println(sb);
  }
}
