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
    StringTokenizer st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int ans = 1;

    String week[] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    int[] m31 = {1, 3, 5, 7, 8, 10, 12};
    int[] m30 = {4, 6, 9, 11};
    for (int i = 1; i < x; i++) {
      if (Arrays.binarySearch(m31, i) >= 0)
        ans += 31;
      else if (Arrays.binarySearch(m30, i) >= 0)
        ans += 30;
      else
        ans += 28;
    }
    ans = (ans + y - 1) % 7;
    System.out.print(week[ans]);
  }
}
