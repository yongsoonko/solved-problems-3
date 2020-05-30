import java.io.*;
import java.util.*;

class Pos implements Comparable<Pos> {
  int i; // 자식 노드의 j 값중에 가장 큰 2개를 더한 값 | 자식 노드 번호
  int j; // 자식 노드의 j 값중에 가장 큰 값 | 간선의 가중치

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
  static int srcCnt[];
  static int parent[]; // 어떤 노드의 부모 노드는 한개
  static Pos A[];
  static List<List<Pos>> J;

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    int V = Integer.parseInt(br.readLine());
    srcCnt = new int[V + 1];
    parent = new int[V + 1];
    A = new Pos[V + 1];
    J = new ArrayList<>();
    for (int i = 0; i <= V; i++) {
      A[i] = new Pos(0, 0); // 객체 배열
      J.add(new ArrayList<>());
    }

    for (int i = 1; i <= V; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b;
      while ((b = Integer.parseInt(st.nextToken())) != -1) {
        int c = Integer.parseInt(st.nextToken());
        J.get(a).add(new Pos(b, c));
      }
    }

    Queue<Integer> Q = new LinkedList<>();
    Q.offer(1);
    parent[1] = -1;

    while (Q.size() > 0) {
      int curr = Q.poll();
      for (Pos next : J.get(curr))
        if (parent[next.i] == 0) {
          srcCnt[curr]++;
          parent[next.i] = curr;
          Q.offer(next.i);
        }
    }

    for (int i = 1; i <= V; i++)
      if (srcCnt[i] == 0)
        Q.offer(i);

    int ans = 0;
    while (Q.size() > 0) {
      int curr = Q.poll(), next = parent[curr];
      if (next == -1)
        break;
      if (--srcCnt[next] == 0) {
        Q.offer(next);
        int sum, first = 0, second = 0;
        for (Pos child : J.get(next)) {
          if (child.i == parent[next]) // 이전 문제와 다른 점(인접리스트가 부모쪽으로도 추가되어있다.)
            continue;
          int w = A[child.i].j + child.j;
          if (first < w) {
            second = first; // 이 부분 실수 하지 말것:먼저 first를 넘겨준다.
            first = w;
          } else if (second < w)
            second = w;
        }
        sum = first + second;
        A[next].i = sum;
        A[next].j = first;
        ans = Math.max(ans, sum);
      }
    }
    log(ans);
  }
}
