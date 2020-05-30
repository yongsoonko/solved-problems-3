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
  char elem;
  Node prev;
  Node next;

  Node(char elem, Node prev, Node next) {
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
    String str = br.readLine();
    Node head = new Node('S', null, null);
    Node curr = head;
    for (char ch : str.toCharArray()) {
      curr.next = new Node(ch, curr, null);
      curr = curr.next;
    }
    int M = Integer.parseInt(br.readLine());
    while (M-- > 0) {
      String op = br.readLine();
      if (op.charAt(0) == 'L' && curr.prev != null)
        curr = curr.prev;
      else if (op.charAt(0) == 'D' && curr.next != null)
        curr = curr.next;
      else if (op.charAt(0) == 'B' && curr.prev != null) {
        Node delNode = curr;
        if (curr.next != null) {
          curr.prev.next = curr.next;
          curr.next.prev = curr.prev;
          curr = curr.prev;
          delNode.prev = delNode.next = null;
        } else {
          curr.prev.next = curr.next;
          curr = curr.prev;
          delNode.prev = null;
        }
      } else if (op.charAt(0) == 'P') {
        Node newNode = new Node(op.charAt(2), curr, curr.next);
        if (curr.next != null)
          curr.next.prev = newNode;
        curr.next = newNode;
        curr = newNode;
      }
    }
    head = head.next;
    while (head != null) {
      bw.write(head.elem);
      head = head.next;
    }
    bw.flush();
  }
}
