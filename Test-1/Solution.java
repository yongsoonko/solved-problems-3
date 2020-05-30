import java.io.*;
import java.util.*;

public class Solution {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static void log(Object o) {
    System.out.print(o);
  }

  public static long solution(long n) {
    long answer = 0;
    long div = 1, cnt = 0;
    while (n > div) {
      div *= 2;
      cnt++;
    }

    while (n > 0) {
      while (n < div) {
        div /= 2;
        cnt--;
      }
      answer += Math.pow(3, cnt);
      n %= div;
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    log(solution((long) 1e9));
  }
}
