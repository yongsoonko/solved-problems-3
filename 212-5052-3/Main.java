import java.io.*;
import java.util.*;

class Trie {
  Trie[] route;
  boolean isEnd, hasNext;

  public Trie() {
    route = new Trie[10];
  }

  boolean insert(char str[], int idx) {
    if (idx == str.length) {
      isEnd = true;
      return !hasNext;
    } else {
      hasNext = true;
      int currRoute = str[idx] - '0';
      if (route[currRoute] == null)
        route[currRoute] = new Trie();
      return !isEnd && route[currRoute].insert(str, idx + 1);
    }
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
    // long start = System.nanoTime();
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      Trie trie = new Trie();
      int flag = 1;
      while (n-- > 0) {
        char str[] = br.readLine().toCharArray();
        if (flag == 1 && !trie.insert(str, 0))
          flag = 0;
      }
      bw.write(flag == 1 ? "YES\n" : "NO\n");
    }
    bw.flush();

    // log("\ntime : " + ((System.nanoTime() - start) / 1000000.) + " ms\n");
  }
}
