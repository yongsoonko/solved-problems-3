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
    int A, B;
    StringTokenizer st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    System.out.print(A + B);
  }
}
