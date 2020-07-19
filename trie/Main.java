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
