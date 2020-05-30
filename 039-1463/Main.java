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
    int[] A = new int[N + 1];
    Arrays.fill(A, (int) 2e9);
    A[N] = 0;

    for (int i = N; i > 1; i--) {
      if (i >= 3 && i % 3 == 0)
        A[i / 3] = Math.min(A[i / 3], A[i] + 1);
      if (i >= 2 && i % 2 == 0)
        A[i / 2] = Math.min(A[i / 2], A[i] + 1);
      A[i - 1] = Math.min(A[i - 1], A[i] + 1);
    }
    System.out.println(A[1]);
  }
}