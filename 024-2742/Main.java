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
    for (int i = N; i >= 1; i--)
      sb.append(i).append('\n');
    System.out.print(sb);
  }
}
