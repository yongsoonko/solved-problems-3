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
  static char dir[] = {'U', 'R', 'D', 'L'};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    int A[][] = new int[R][C];
    int min = (int) 1e9, mini = 0, minj = 0;
    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < C; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
        if ((i + j) % 2 == 1 && min > A[i][j]) {
          min = A[i][j];
          mini = i;
          minj = j;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    if (R % 2 == 1) {
      for (int j = 0; j < R / 2; j++)
        move(sb, 1, C);
      for (int i = 1; i < C; i++)
        sb.append('R');
    } else if (C % 2 == 1) {
      for (int j = 0; j < C / 2; j++)
        move(sb, 2, R);
      for (int i = 1; i < R; i++)
        sb.append('D');
    } else {
      for (int i = 0; i < mini / 2; i++)
        move(sb, 1, C);
      sb.append('D');
      for (int j = 0; j < C / 2; j++) {
        if (j >= 1)
          sb.append("RURD");
        if (j == minj / 2) {
          if (mini % 2 == 0)
            sb.append('R');
          else
            sb.insert(sb.length() - 1, 'R');
        }
      }
      sb.append('D');
      for (int i = mini / 2 + 1; i < R / 2; i++)
        move(sb, 3, C);
      sb.deleteCharAt(sb.length() - 1);
    }
    log(sb);
  }

  static void move(StringBuilder sb, int d, int cnt) {
    for (int i = 1; i < cnt; i++)
      sb.append(dir[d]);
    int tmp = d;
    d = d % 2 == 0 ? 1 : 2;
    sb.append(dir[d]);
    d = (tmp + 2) % 4;
    for (int i = 1; i < cnt; i++)
      sb.append(dir[d]);
    d = d % 2 == 0 ? 1 : 2;
    sb.append(dir[d]);
  }
}
