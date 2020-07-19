import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    int seq[] = IntStream.range(0, 10).toArray();
    Random rd = new Random();
    for (int i = 9; i >= 7; i--) {
      int idx = rd.nextInt(i + 1);
      int tmp = seq[i];
      seq[i] = seq[idx];
      seq[idx] = tmp;
    }
    int ans[] = Arrays.copyOfRange(seq, 7, 10);
    int chk[] = new int[10];
    System.out.print("정답 : ");
    for (int i : ans) {
      chk[i] = 1;
      System.out.print(i + " ");
    }
    System.out.println();

    int input[] = new int[3];
    Scanner sc = new Scanner(System.in);
    while (true) {
      for (int i = 0; i < 3; i++)
        input[i] = sc.nextInt();

      int s = 0, b = 0;
      for (int i = 0; i < 3; i++)
        if (chk[input[i]] == 1) {
          if (ans[i] == input[i])
            s++;
          else
            b++;
        }
      System.out.println(s + b > 0 ? s + "S " + b + "B" : "OUT");
      if (s == 3)
        break;
    }
  }
}
