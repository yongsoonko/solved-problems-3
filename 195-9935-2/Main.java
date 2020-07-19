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
    // long start = System.nanoTime();
    char A[] = br.readLine().toCharArray();
    String B = br.readLine();

    StringBuilder sb = new StringBuilder();
    Stack<Integer> S = new Stack<>();
    S.push(-1);
    for (int i = 0; i < A.length; i++) {
      sb.append(A[i]);
      if (B.charAt(S.peek() + 1) == A[i])
        S.push(S.peek() + 1);
      else
        S.push(A[i] == B.charAt(0) ? 0 : -1);
      if (S.peek() == B.length() - 1)
        for (int j = 0; j < B.length(); j++) {
          S.pop();
          sb.deleteCharAt(sb.length() - 1);
        }
    }

    log(sb.length() == 0 ? "FRULA" : sb);

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
