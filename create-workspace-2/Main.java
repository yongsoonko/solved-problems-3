import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    File dstDir = new File("C:/Users/Yongsoon Ko/Documents/lecture/CPS_testcase-3");
    File srcJudge = new File("C:/Users/Yongsoon Ko/Documents/lecture/CPS_testcase-3/Judge.class");
    BufferedInputStream bis = null;
    BufferedOutputStream bos = null;
    byte buff[] = new byte[512];
    int cnt;

    for (String str : dstDir.list()) {
      File f = new File(dstDir, str);
      if (f.isDirectory()) {
        File dstJudge = new File(f, "Judge.class");
        try {
          bis = new BufferedInputStream(new FileInputStream(srcJudge), 512);
          bos = new BufferedOutputStream(new FileOutputStream(dstJudge), 512);

          while ((cnt = bis.read(buff)) != -1)
            bos.write(buff, 0, cnt);
          bos.flush();

          // File java = new File(f, "Main.java");
          // java.createNewFile();
          dstJudge.createNewFile();
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          try {
            if (bis != null)
              bis.close();
            if (bos != null)
              bos.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
