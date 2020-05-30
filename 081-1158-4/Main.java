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


class Node {
  int elem;
  Node prev;
  Node next;

  Node(int elem, Node prev, Node next) {
    this.elem = elem;
    this.prev = prev;
    this.next = next;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    bw.write('<');
    Node head = new Node(1, null, null);
    Node curr = head;
    for (int i = 2; i <= N; i++) {
      curr.next = new Node(i, curr, null);
      curr = curr.next;
    }
    curr.next = head;
    head.prev = curr;

    int cnt = 0, kCnt = 0;
    while (cnt < N) {
      curr = curr.next;
      if (++kCnt % K == 0) {
        bw.write(++cnt < N ? curr.elem + ", " : curr.elem + ">");
        Node delNode = curr;
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        curr = curr.prev;
        delNode.prev = delNode.next = null;
      }
    }
    bw.flush();
  }
}
