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
    for (int i = 1; i <= N; i++) {
      for (int j = i; j < N; j++)
        sb.append(' ');
      for (int j = 1; j <= i; j++)
        sb.append('*');
      sb.append('\n');
    }
    System.out.print(sb);
  }
}
