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

  public static int[] solution(int total_sp, int[][] skills) {
    int N = skills.length + 1;
    int[] answer = new int[N];
    int[] cnt = new int[N + 1];
    int[] childCnt = new int[N + 1];
    ArrayList<ArrayList<Integer>> Edge = new ArrayList<>();
    for (int i = 0; i <= N; i++)
      Edge.add(new ArrayList<>());

    for (int[] a : skills) {
      cnt[a[0]]++;
      Edge.get(a[1]).add(a[0]);
    }

    int childSum = 0;
    Queue<Integer> Q = new LinkedList<>();
    for (int i = 1; i <= N; i++)
      if (cnt[i] == 0) {
        Q.offer(i);
        childCnt[i] = 1;
        childSum++;
      }

    while (Q.size() > 0) {
      int sz = Q.size();
      while (sz-- > 0) {
        int curr = Q.poll();
        for (int next : Edge.get(curr)) {
          cnt[next]--;
          childCnt[next] += childCnt[curr];
          childSum += childCnt[curr];
          if (cnt[next] == 0)
            Q.offer(next);
        }
      }
    }

    int div = total_sp / childSum;
    for (int i = 1; i <= N; i++)
      answer[i - 1] = div * childCnt[i];

    return answer;
  }

  public static void main(String[] args) throws IOException {
    int[][] skills = new int[][] {{1, 2}, {1, 3}, {3, 6}, {3, 4}, {3, 5}};
    solution(121, skills);
    for (int i : solution(121, skills))
      log(i + " ");
  }
}
