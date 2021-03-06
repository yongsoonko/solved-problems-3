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

    char str[] = new char[] {'U', 'R', 'D', 'L'};
    if (R % 2 == 1) {
      mini = -2;
      minj = -2;
    } else if (C % 2 == 1) {
      mini = -2;
      minj = -2;
      int B[][] = new int[C][R];
      for (int j = 0; j < C; j++)
        for (int i = 0; i < R; i++)
          B[j][i] = A[i][j];
      str = new char[] {'L', 'D', 'R', 'U'};
      A = B;
      int tmp = R;
      R = C;
      C = tmp;
    }

    int i = 0, j = 0, d = i / 2 == mini / 2 ? 2 : 1;
    while (i < R) {
      if (i / 2 == mini / 2) {
        if (j == minj) {
          int tmp = d;
          d = 1;
          i += di[d];
          j += dj[d];
          bw.write(str[d]);
          d = tmp;
        } else {
          i += di[d];
          j += dj[d];
          bw.write(str[d]);
          d = d % 2 == 0 ? 1 : i % 2 == 0 ? 2 : 0;
        }
        if (i % 2 == 1 && j == C - 1) {
          if (++i < R)
            bw.write(str[2]);
          d = 3;
        }
      } else {
        i += di[d];
        j += dj[d];
        bw.write(str[d]);
        if (j == 0 || j == C - 1) {
          if (++i < R)
            bw.write(str[2]);
          d = i / 2 == mini / 2 ? 2 : j == 0 ? 1 : 3;
        }
      }
    }
    bw.flush();
  }
}
