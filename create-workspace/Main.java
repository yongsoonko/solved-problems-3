import java.io.File;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    File src = new File("C:/Users/Yongsoon Ko/Documents/solved-problems-2");
    File dst = new File("C:/Users/Yongsoon Ko/Documents/solved-problems-3");

    for (String str : src.list()) {
      File f = new File(dst, str.substring(0, str.lastIndexOf('.')));
      if (f.exists() == false)
        f.mkdir();
      File java = new File(f, "Main.java");
      try {
        if (java.exists() == false)
          java.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
