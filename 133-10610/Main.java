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


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    char str[] = br.readLine().toCharArray();
    Arrays.sort(str);

    int sum = 0;
    for (char ch : str)
      sum += ch - '0';

    if (sum % 3 == 0 && str[0] == '0')
      for (int i = str.length - 1; i >= 0; i--)
        bw.write(str[i]);
    else
      bw.write("-1");
    bw.flush();
  }
}
