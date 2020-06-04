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
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    long ans = 0;

    int A[][] = new int[N + 1][M + 1];
    for (int i = 1; i <= N; i++) {
      String str = br.readLine();
      for (int j = 1; j <= M; j++)
        A[i][j] = str.charAt(j - 1) - '0';
    }

    int S[][] = new int[N + 1][M + 1];
    for (int i = 1; i <= N; i++)
      for (int j = 1; j <= M; j++)
        S[i][j] = A[i][j] + S[i - 1][j] + S[i][j - 1] - S[i - 1][j - 1];


    // 二 
    for (int i = 1; i < N - 1; i++)
      for (int j = i + 1; j < N; j++) {
        long a = S[i][M];
        long b = S[j][M] - a;
        long c = S[N][M] - a - b;
        ans = Math.max(ans, a * b * c);
      }

    // || 
    for (int i = 1; i < M - 1; i++)
      for (int j = i + 1; j < M; j++) {
        long a = S[N][i];
        long b = S[N][j] - a;
        long c = S[N][M] - a - b;
        ans = Math.max(ans, a * b * c);
      }

    // ㅗ
    for (int i = 1; i < N - 1; i++)
      for (int j = 1; j < M - 1; j++) {
        long a = S[i][j];
        long b = S[i][M] - a;
        long c = S[N][M] - a - b;
        ans = Math.max(ans, a * b * c);
      }

    // ㅜ
    for (int i = 1; i < N; i++)
      for (int j = 1; j < M; j++) {
        long a = S[i][M];
        long b = S[N][j] - S[i][j];
        long c = S[N][M] - a - b;
        ans = Math.max(ans, a * b * c);
      }

    // ㅓ
    for (int i = 1; i < N; i++)
      for (int j = 1; j < M; j++) {
        long a = S[i][j];
        long b = S[N][j] - a;
        long c = S[N][M] - a - b;
        ans = Math.max(ans, a * b * c);
      }

    // ㅏ
    for (int i = 1; i < N; i++)
      for (int j = 1; j < M; j++) {
        long a = S[N][j];
        long b = S[i][M] - S[i][j];
        long c = S[N][M] - a - b;
        ans = Math.max(ans, a * b * c);
      }

    log(ans);
  }
}
