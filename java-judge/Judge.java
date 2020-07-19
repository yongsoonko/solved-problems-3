import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Judge {

  public static void main(String[] args) {
    BufferedReader sol = null, ans = null;
    System.out.println();
    try {
      ProcessBuilder pb = new ProcessBuilder("java", "Main");
      out: for (int i = 1; i <= 5; i++) {
        File in = new File("in" + i + ".txt");
        File out = new File("out" + i + ".txt");

        pb.redirectInput(in);

        long start = System.nanoTime();
        Process pc = pb.start();

        sol = new BufferedReader(new InputStreamReader(pc.getInputStream()), 512);
        ans = new BufferedReader(new InputStreamReader(new FileInputStream(out)), 512);

        if (pc.waitFor(15, TimeUnit.SECONDS)) {
          String solStr, ansStr;
          while ((ansStr = ans.readLine()) != null) {
            if ((solStr = sol.readLine()) == null || !solStr.trim().equals(ansStr.trim())) {
              System.out.println("Wrong Answer!");
              break out;
            }
          }
          System.out.println("Accepted!\t" + ((System.nanoTime() - start) / 1000000.) + " ms");
        } else
          System.out
              .println("Time Limit Exceeded!\t" + ((System.nanoTime() - start) / 1000000.) + " ms");
      }
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      try {
        if (sol != null)
          sol.close();
        if (ans != null)
          ans.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
