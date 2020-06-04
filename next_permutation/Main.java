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
    int A[] = {1, 2, 3};
    do {
      for (int i : A)
        bw.write(i + " ");
      bw.write('\n');
    } while (next_permutation(A));
    bw.flush();
  }

  static void swap(int A[], int i, int j) {
    if (A[i] != A[j]) {
      A[i] ^= A[j];
      A[j] ^= A[i];
      A[i] ^= A[j];
    }
  }

  // x : 피봇 갱신 위치
  //
  // .\
  // ..\../\
  // ...\/..\
  // ........\
  // .....xx..
  // 결과적으로 가장 나중에 있는 봉우리 위치가 피봇이 된다.

  static boolean next_permutation(int A[]) {
    int pv = 0;
    for (int i = 1; i < A.length; i++)
      if (A[i - 1] < A[i])
        pv = i;

    // 처음부터 끝까지 내림차순인 경우
    // 더 이상 다음 순열이 존재하지 않는다.
    if (pv == 0)
      return false;

    // 스왑 이후에도 피봇부터의 내림차순이 
    // 유지된다.
    for (int i = A.length - 1; i >= pv; i--)
      if (A[i] > A[pv - 1]) {
        swap(A, i, pv - 1);
        break;
      }

    // 피봇부터의 내림차순을 역순으로 하여
    // 다시 가장 작은 수로 시작한다.
    int p = pv, q = A.length - 1;
    while (p < q)
      swap(A, p++, q--);

    return true;
  }
}
