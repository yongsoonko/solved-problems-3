import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int i;
  int j;

  Pos(int i, int j) {
    this.i = i;
    this.j = j;
  }

  public int compareTo(Pos p) {
    return i == p.i ? j - p.j : i - p.i;
  }
}


public class Solution {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static boolean chk[] = new boolean[10];

  static void log(Object o) {
    System.out.print(o);
  }

static public int solution(int p) {
  int answer = 0;
  for (int i = p + 1; i <= 10000; i++) {
    Arrays.fill(chk, false);
    int num = i;
    while (num > 0 && !chk[num % 10]) {
      chk[num % 10] = true;
      num /= 10;
    }
    if (num == 0) {
      answer = i;
      break;
    }
  }
  return answer;
}

  public static void main(String[] args) throws IOException {
    log(solution(2016));
  }
}
