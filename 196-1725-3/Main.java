import java.io.*;
import java.util.*;

// class Pos /* implements Comparable<Pos> */ {}

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());
    int A[] = new int[N + 2];
    for (int i = 1; i <= N; i++)
      A[i] = Integer.parseInt(br.readLine());

    int ans = 0;
    Stack<Integer> S = new Stack<>();
    S.push(0);
    for (int i = 1; i <= N + 1; i++) {
      while (A[S.peek()] > A[i]) {
        int h = A[S.peek()];
        S.pop();
        int w = i - (S.peek() + 1);
        ans = Math.max(ans, w * h);
      }
      S.push(i);
    }
    log(ans);
  }
}
